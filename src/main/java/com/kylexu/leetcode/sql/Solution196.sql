# Write your MySQL query statement below

delete
from Person
where id in (select id
             from (select id, row_number() over (partition by Email order by id) as rk
                   from Person) a
             where rk != 1)