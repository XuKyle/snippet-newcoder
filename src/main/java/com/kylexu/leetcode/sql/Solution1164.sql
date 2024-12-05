# Write your MySQL query statement below

with product_info as (select distinct a.product_id
                      from Products a)
   , stat_info as (select a.product_id,
                          if(b.product_id is not null, b.new_price, 10)                             as price,
                          row_number() over (partition by a.product_id order by b.change_date desc) as rk
                   from product_info a
                            left join Products b on b.change_date <= '2019-08-16' and a.product_id = b.product_id)
select product_id, price
from stat_info
where rk = 1