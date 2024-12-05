# Write your MySQL query statement below
with stat_info as (
    select a.id from Employee a
                         join  Employee b on b.managerId = a.id
    group by  a.id
    having  count(*) >=5
)
select a.name from Employee a join stat_info b on a.id = b.id