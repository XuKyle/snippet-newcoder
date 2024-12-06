# Write your MySQL query statement below
with stat_info as (select visited_on, count(*) as customer_num, sum(amount) as all_mount
                   from Customer
                   group by visited_on)
   , rs_info as (select visited_on,
                        sum(customer_num) over (order by visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW) as leiji_customer_num,
                        sum(all_mount) over (order by visited_on ROWS BETWEEN 6 PRECEDING AND CURRENT ROW)    as leiji_all_mount,
                        row_number() over (order by visited_on)                                               as rk
                 from stat_info)

select visited_on,
       leiji_all_mount                 as amount,
       round((leiji_all_mount / 7), 2) as average_amount
from rs_info
where rk >= 7
order by visited_on