# Write your MySQL query statement below


with month_info as (select 'Jan' as month_str
                    union
                    select 'Feb' as month_str
                    union
                    select 'Mar' as month_str
                    union
                    select 'Apr' as month_str
                    union
                    select 'May' as month_str
                    union
                    select 'Jun' as month_str
                    union
                    select 'Jul' as month_str
                    union
                    select 'Aug' as month_str
                    union
                    select 'Sep' as month_str
                    union
                    select 'Oct' as month_str
                    union
                    select 'Nov' as month_str
                    union
                    select 'Dec' as month_str)
select b.id,
       sum((case when a.month_str = 'Jan' then b.revenue end)) as Jan_Revenue,
       sum((case when a.month_str = 'Feb' then b.revenue end)) as Feb_Revenue,
       sum((case when a.month_str = 'Mar' then b.revenue end)) as Mar_Revenue,
       sum((case when a.month_str = 'Apr' then b.revenue end)) as Apr_Revenue,
       sum((case when a.month_str = 'May' then b.revenue end)) as May_Revenue,
       sum((case when a.month_str = 'Jun' then b.revenue end)) as Jun_Revenue,
       sum((case when a.month_str = 'Jul' then b.revenue end)) as Jul_Revenue,
       sum((case when a.month_str = 'Aug' then b.revenue end)) as Aug_Revenue,
       sum((case when a.month_str = 'Sep' then b.revenue end)) as Sep_Revenue,
       sum((case when a.month_str = 'Oct' then b.revenue end)) as Oct_Revenue,
       sum((case when a.month_str = 'Nov' then b.revenue end)) as Nov_Revenue,
       sum((case when a.month_str = 'Dec' then b.revenue end)) as Dec_Revenue
from month_info a
         left join Department b on a.month_str = b.month
where b.id is not null
group by b.id