# Write your MySQL query statement below

select a.name,
       ifnull(b.travelled_distance, 0) as travelled_distance
from Users a
         left join
     (select user_id, sum(distance) as travelled_distance
      from Rides
      group by user_id) b on a.id = b.user_id
order by travelled_distance desc, a.name