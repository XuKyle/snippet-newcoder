# Write your MySQL query statement below

with prod_count as (select count(distinct product_key) as num
                    from Product)
select a.customer_id
from (select a.customer_id,
             count(distinct product_key) as num
      from Customer a
      group by a.customer_id) a
         join prod_count b
where a.num = b.num

