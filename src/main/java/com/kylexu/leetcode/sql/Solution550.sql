with all_player as (
    select count(distinct player_id) as num from Activity
)
   ,act_info as (
    select a.player_id, date_add(min(a.event_date),interval 1 day) as event_date
    from Activity a
    group by  a.player_id
)
select
    ifnull(round(count(*)/max(c.num),2),0) as fraction
from act_info a
         join Activity b on a.player_id = b.player_id and a.event_date = b.event_date
         join all_player c