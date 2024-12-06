# Write your MySQL query statement below
with stat_info as (select salary, dense_rank() over (order by salary desc ) as rk
                   from Employee),
     max_rk as (select max(rk) as rk, count(*) as cnt
                from stat_info)
select salary as SecondHighestSalary
from stat_info
where rk = 2
union
select null as SecondHighestSalary
from max_rk
where (rk < 2 or cnt = 0)