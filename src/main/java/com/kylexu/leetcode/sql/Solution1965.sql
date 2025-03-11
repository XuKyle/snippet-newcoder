with gm as (select employee_id
            from Employees
            union all
            select employee_id
            from Salaries)
select employee_id
from gm
group by employee_id
having count(*) = 1
order by employee_id