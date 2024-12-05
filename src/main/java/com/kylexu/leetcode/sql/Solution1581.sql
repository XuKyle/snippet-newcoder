# Write your MySQL query statement below
select
    a.customer_id,
    count(*) - sum(if(b.visit_id is not null,1,0))
        as count_no_trans
from
    Visits a
        left join Transactions b on a.visit_id = b.visit_id
where b.visit_id is null
group by a.customer_id