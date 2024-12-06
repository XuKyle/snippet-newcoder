# Write your MySQL query statement below


with stat_info as (select a.*, row_number() over (partition by a.pid order by a.tiv_2015) as rk
                   from Insurance a
                            join Insurance b on a.tiv_2015 = b.tiv_2015
                            left join Insurance c on a.lon = c.lon and a.lat = c.lat and a.pid != c.pid
                   where a.pid != b.pid
                     and a.lat != b.lat
                     and a.lon != b.lon
                     and c.pid is null)
select round(sum(tiv_2016), 2) as tiv_2016
from stat_info
where rk = 1