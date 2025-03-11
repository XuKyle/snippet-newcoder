with gm as (select customer_number,
                   dense_rank() over (order by count(*) desc) as rk
            From orders
            group by customer_number)
select customer_number
From gm
where rk = 1