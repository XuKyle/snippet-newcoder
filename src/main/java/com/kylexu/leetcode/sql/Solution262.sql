select
    t.request_at as 'Day',
    # count(*) as 'Total',
    # sum(if(t.status <> 'completed',1,0)) as 'Cancel',
    round(sum(if(t.status <> 'completed', 1, 0)) / count(*), 2) as 'Cancellation Rate'
from
    Trips as t
        left join Users as c on t.client_id = c.users_id
        left join Users as d on t.driver_id = d.users_id
where
    t.request_at between '2013-10-01' and '2013-10-03'
  and c.banned = 'No'
  and d.banned = 'No'
group by
    t.request_at