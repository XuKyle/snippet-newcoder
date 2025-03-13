# Write your MySQL query statement below


with gm as (select *,
                   length(ip) - length(replace(ip, '.', ''))                dot_count,
                   substring_index(substring_index(ip, ".", 1), '.', -1) as part1,
                   substring_index(substring_index(ip, ".", 2), '.', -1) as part2,
                   substring_index(substring_index(ip, ".", 3), '.', -1) as part3,
                   substring_index(substring_index(ip, ".", 4), '.', -1) as part4
            from logs)
select ip, count(*) as invalid_count
from gm
where (
          cast(part1 as unsigned) > 255 or
          cast(part2 as unsigned) > 255 or
          cast(part3 as unsigned) > 255 or
          cast(part4 as unsigned) > 255 or
          substring(part1, 1, 1) = '0' or
          substring(part2, 1, 1) = '0' or
          substring(part3, 1, 1) = '0' or
          substring(part4, 1, 1) = '0' or
          dot_count != 3
          )
group by ip
order by count(*) desc, ip desc