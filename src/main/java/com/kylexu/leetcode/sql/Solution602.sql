with rs_info as (select requester_id, accepter_id
                 from RequestAccepted
                 union
                 select accepter_id, requester_id
                 from RequestAccepted)
   , stat_info as (select requester_id,
                          count(*)                                   as num,
                          row_number() over (order by count(*) desc) as rk
                   from rs_info
                   group by requester_id)
select requester_id as id, num
from stat_info
where rk = 1
