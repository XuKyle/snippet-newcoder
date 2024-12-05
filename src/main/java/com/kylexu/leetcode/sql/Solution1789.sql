# Write your MySQL query statement below

with depart_info as (
    select employee_id,department_id from
        Employee
    where primary_flag = 'Y'
),
     one_depart as (
         select employee_id from  Employee
         group by  employee_id
         having  count(*) = 1
     )

select a.employee_id,a.department_id from
    Employee a
        join one_depart b on a.employee_id = b.employee_id
union
select  employee_id, department_id
from depart_info