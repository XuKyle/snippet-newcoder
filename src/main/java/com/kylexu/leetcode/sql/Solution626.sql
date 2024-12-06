with num_info as (select (
                             case
                                 when count(*) % 2 = 0 then count(*)
                                 else count(*) - 1
                                 end
                             )
                             as num
                  from Seat)
   , all_info as (select (case
                              when id % 2 = 0 then id - 1
                              else id + 1
    end
    ) as id
                       , student
                  from Seat a
                           join num_info b
                  where a.id <= b.num
                  union
                  select id, student
                  from Seat a
                           join num_info b
                  where a.id > b.num)
select id, student
from all_info
order by id