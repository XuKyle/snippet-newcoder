# Write your MySQL query statement below


with root_info as (select id, 'Root' as type
                   from Tree
                   where p_id is null),
     inner_info as (select distinct p_id, 'Inner' as type
                    from Tree a
                             left join root_info b on a.p_id = b.id
                    where b.id is null
                      and a.p_id is not null),
     leaf_info as (select distinct a.id, 'Leaf' as type
                   from Tree a
                            left join Tree b on a.id = b.p_id
                            left join root_info c on a.id = c.id
                   where b.p_id is null
                     and c.id is null)
select *
from root_info
union
select *
from inner_info
union
select *
from leaf_info
