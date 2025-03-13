with gm as (select *,
                   (lag(id) over ())                      as real_pre_id,
                   lag(id, 1, id - 1) over ()             as pre_id,
                   (lag(id, 1, id - 1) over () = id - 1)  as pre_same_flag,
                   (lead(id) over ())                     as real_next_id,
                   lead(id, 1, id + 1) over ()            as next_id,
                   (lead(id, 1, id + 1) over () = id + 1) as next_same_flag
            from Stadium
            where people >= 100)
   , gm1 as (select *,
                    sum(if(next_same_flag = 0, 1, 0)) over (order by id) as group_flag
             from gm)
   , final_info as (select *,
                           if(pre_same_flag = 1 and next_same_flag = 0, group_flag - 1, group_flag) as rejust_group_flag
                    from gm1
                    where (pre_same_flag + next_same_flag) != 0)
   , group_info as (select rejust_group_flag
                    from final_info
                    where people >= 100
                    group by rejust_group_flag
                    having count(*) >= 3)
select a.id,
       a.visit_date,
       a.people
from final_info a
         join group_info b on a.rejust_group_flag = b.rejust_group_flag
order by a.visit_date

#

    with morethan as
(
    select id,visit_date,people
    from stadium
    where people>=100
),
rankn as
(
    select id,visit_date,people,
    id-(row_number() over(order by id asc)) as gprk
    from morethan
),
gprank as
(
    select gprk,count(gprk) as cnt
    from rankn
    group by gprk
    having cnt>=3
)
select id,visit_date,people
from rankn
where gprk in (select gprk from gprank)

