with  base_info as (
    select
        a.customer_id,
        a.order_date,
        a.customer_pref_delivery_date,
        row_number() over (partition by a.customer_id order by  order_date) as rk
    from Delivery a
)
select
    round(sum(if(order_date = customer_pref_delivery_date,1,0)) *100/count(*),2) as immediate_percentage
from
    base_info
where  rk = 1