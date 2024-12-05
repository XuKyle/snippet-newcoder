# Write your MySQL query statement below

with stu as (
    select * from
        Students a
            join Subjects c
)

select
    a.student_id,a.student_name,a.subject_name,sum(if(b.student_id is not null,1,0)) attended_exams
from
    stu a
        left join Examinations b  on a.student_id = b.student_id and a.subject_name = b.subject_name
group by a.student_id,a.student_name,a.subject_name
order by  a.student_id,a.subject_name