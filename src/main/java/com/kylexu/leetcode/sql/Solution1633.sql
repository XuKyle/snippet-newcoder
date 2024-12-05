# Write your MySQL query statement below

with all_count as (select count(*) as num
                   from Users)
   , tb_info as (select contest_id, round(count(*) * 100 / b.num, 2) as percentage
                 from Register a
                          join all_count b
                 group by contest_id)
select *
from tb_info
order by percentage desc, contest_id asc