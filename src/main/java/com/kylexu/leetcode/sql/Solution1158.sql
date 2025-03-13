select *
from Users;
select *
from Items;
select *
from Orders;

# 写解决方案找出每个用户的注册日期和在 2019 年作为买家的订单总数。
# 以 任意顺序 返回结果表。
# 查询结果格式如下。
# 输出：
# +-----------+------------+----------------+
# | buyer_id  | join_date  | orders_in_2019 |
# +-----------+------------+----------------+
# | 1         | 2018-01-01 | 1              |
# | 2         | 2018-02-09 | 2              |
# | 3         | 2018-01-19 | 0              |
# | 4         | 2018-05-21 | 0              |
# +-----------+------------+----------------+


with gm as (select buyer_id, count(*) as orders_in_2019
            from Orders
            where substring(order_date, 1, 4) = '2019'
            group by buyer_id)
select a.user_id, a.join_date, coalesce(b.orders_in_2019, 0) as orders_in_2019
from Users a
         left join gm b on a.user_id = b.buyer_id
;
