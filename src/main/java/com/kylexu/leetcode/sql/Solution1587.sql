# Write your MySQL query statement below

select
    b.name as name ,sum(amount) as balance
from Transactions a join Users b on a.account = b.account
group by b.name
having  sum(amount) > 10000