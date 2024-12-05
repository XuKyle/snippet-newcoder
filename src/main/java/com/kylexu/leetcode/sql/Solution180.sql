# Write your MySQL query statement below


select distinct b.num as ConsecutiveNums
from (select a.num,
             (a.id - a.rk) as gap
      from (select id,
                   num,
                   row_number() over (partition by num order by id) as rk
            from Logs) a
      group by a.num, (a.id - a.rk)
      having count(*) >= 3) b