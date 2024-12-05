# Write your MySQL query statement below

with product as (
    select distinct product_id from prices
),avg_info as (
    select
        a.product_id,round(sum(a.price * b.units)/sum(b.units),2) as average_price
    from prices
             a join UnitsSold b on a.product_id = b.product_id and a.start_date <= b.purchase_date and a.end_date >= b.purchase_date
    group by  a.product_id
)
select
    a.product_id,if(b.product_id is not null,b.average_price,0) as average_price
from product a
         left join avg_info b on a.product_id = b.product_id