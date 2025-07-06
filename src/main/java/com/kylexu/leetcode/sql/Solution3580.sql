# Write your MySQL query statement below


with stat_info as (select *,
                          row_number() over (partition by employee_id order by review_date desc)            as rk,
                          lead(rating) over (partition by employee_id order by review_date desc)            as last_rating,
                          (rating - lead(rating) over (partition by employee_id order by review_date desc)) as gain_rating
                   from performance_reviews)
   , condition_info1 as (select employee_id
                         from stat_info
                         group by employee_id
                         having count(*) >= 3)
   , condition_info2 as (select employee_id, count(*) as increasing_count
                         from stat_info
                         where rk < 3
                           and gain_rating > 0
                         group by employee_id
                         having count(*) >= 2)

select a.employee_id,
       a.name                as name,
       (b.rating - c.rating) as improvement_score
from employees a
         join condition_info1 d on a.employee_id = d.employee_id
         join condition_info2 d1 on a.employee_id = d1.employee_id
         join stat_info b on a.employee_id = b.employee_id and b.rk = 1
         join stat_info c on a.employee_id = c.employee_id and c.rk = 3

order by (b.rating - c.rating) desc, a.name