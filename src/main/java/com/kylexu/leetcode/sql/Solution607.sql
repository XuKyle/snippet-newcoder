select
    a.name
from SalesPerson a left join (
    select a.*
    from orders a
             join Company b on a.com_id = b.com_id
    where b.name = 'RED') b on a.sales_id = b.sales_id
where b.sales_id is null
;
