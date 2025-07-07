-- select *
-- from ProductPurchases;
-- select *
-- from ProductInfo;
#
# 亚马逊希望根据 共同购买模式 实现 “购买此商品的用户还购买了...” 功能。编写一个解决方案以实现：
#
# 识别 被同一客户一起频繁购买的 不同 产品对（其中 product1_id < product2_id）
# 对于 每个产品对，确定有多少客户购买了这两种产品
# 如果 至少有 3 位不同的 客户同时购买了这两种产品，则认为该 产品对 适合推荐。
#
# 返回结果表以 customer_count  降序 排序，并且为了避免排序持平，以 product1_id 升序 排序，并以 product2_id 升序 排序。
#
# 输出：
#
# +-------------+-------------+-------------------+-------------------+----------------+
# | product1_id | product2_id | product1_category | product2_category | customer_count |
# +-------------+-------------+-------------------+-------------------+----------------+
# | 101         | 102         | Electronics       | Books             | 3              |
# | 101         | 103         | Electronics       | Clothing          | 3              |
# | 102         | 104         | Books             | Kitchen           | 3              |
# +-------------+-------------+-------------------+-------------------+----------------+
# 解释：


with base_info as (select a.product_id as product1_id, b.product_id as product2_id, a.user_id
                   from ProductPurchases a
                            join ProductPurchases b on a.user_id = b.user_id
                   where a.product_id < b.product_id)
   , stat_info as (select product1_id, product2_id, count(distinct user_id) as customer_count
                   from base_info a
                   group by product1_id, product2_id
                   having count(distinct user_id) >= 3)
select a.product1_id,
       a.product2_id,
       b.category as product1_category,
       c.category as product2_category,
       a.customer_count
from stat_info a
         join ProductInfo b on a.product1_id = b.product_id
         join ProductInfo c on a.product2_id = c.product_id
order by customer_count desc, product1_id, product2_id