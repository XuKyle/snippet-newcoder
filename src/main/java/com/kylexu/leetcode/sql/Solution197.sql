# Write your MySQL query statement below
select b.id from
    Weather a
        join Weather b on date_add(a.recordDate,INTERVAL 1 day) =  b.recordDate
where b.temperature > a.temperature

