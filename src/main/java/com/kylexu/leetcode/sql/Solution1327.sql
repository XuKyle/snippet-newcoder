# Write your MySQL query statement below


with stat_info as (
    select product_id,sum(unit) as units from Orders
    where substring(order_date,1,7) = '2020-02'
    group by product_id
    having  sum(unit) >=100
)
select
    b.product_name,a.units as unit
from stat_info a join Products b on a.product_id = b.product_id