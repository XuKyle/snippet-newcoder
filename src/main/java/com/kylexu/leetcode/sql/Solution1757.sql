select  * from Products
where low_fats = 'Y' and recyclable = 'Y'

# product_id 是该表的主键（具有唯一值的列）。
# low_fats 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品是低脂产品，'N' 表示不是低脂产品。
# recyclable 是枚举类型，取值为以下两种 ('Y', 'N')，其中 'Y' 表示该产品可回收，而 'N' 表示不可回收。
#
#
# 编写解决方案找出既是低脂又是可回收的产品编号。
#
# 返回结果 无顺序要求 。
#
# 返回结果格式如下例所示：