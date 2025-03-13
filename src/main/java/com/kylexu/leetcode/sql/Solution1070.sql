# Write your MySQL query statement below

with gm as (select product_id, min(year) as first_year
            from Sales
            group by product_id)
select b.product_id,
       b.year as first_year,
       b.quantity,
       b.price
From gm a
         join Sales b on a.product_id = b.product_id and a.first_year = b.year