# Write your MySQL query statement below


with tb as (select "Low Salary" as type
            union all
            select "Average Salary" as type
            union all
            select "High Salary" as type)
   , acct_info as (select account_id,
                          (
                              case
                                  when income < 20000 then "Low Salary"
                                  when income >= 20000 and income <= "50000" then "Average Salary"
                                  else "High Salary"
                                  end
                              ) as type
                   from Accounts)
select a.type as category, sum(if(b.account_id is not null, 1, 0)) as accounts_count
from tb a
         left join acct_info b on a.type = b.type
group by a.type
