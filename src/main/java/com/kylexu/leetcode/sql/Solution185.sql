with stat_info as (select id,
                          name,
                          departmentId,
                          salary,
                          dense_rank() over (partition by departmentId order by salary desc) as rk
                   from Employee)
select b.name as Department,
       a.name as Employee,
       a.salary
from stat_info a
         join Department b on a.departmentId = b.id
where rk <= 3