# Write your MySQL query statement below
with gm as (select *,
                   dense_rank() over (partition by departmentId order by salary desc) as rk
            from Employee)
select b.name   as Department,
       a.name   as Employee,
       a.salary as Salary
from gm a
         join Department b on a.departmentId = b.id
where a.rk = 1