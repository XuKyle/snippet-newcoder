select name from Customer where referee_id != 2 or referee_id is null ;
# Create table If Not Exists Customer (id int, name varchar(25), referee_id int);
# Truncate table Customer;
# insert into Customer (id, name, referee_id) values ('1', 'Will', NULL);
# insert into Customer (id, name, referee_id) values ('2', 'Jane', NULL);
# insert into Customer (id, name, referee_id) values ('3', 'Alex', '2');
# insert into Customer (id, name, referee_id) values ('4', 'Bill', NULL);
# insert into Customer (id, name, referee_id) values ('5', 'Zack', '1');
# insert into Customer (id, name, referee_id) values ('6', 'Mark', '2');
#
# 在 SQL 中，id 是该表的主键列。
# 该表的每一行表示一个客户的 id、姓名以及推荐他们的客户的 id。
# 找出那些 没有被 id = 2 的客户 推荐 的客户的姓名。
#
# 以 任意顺序 返回结果表。
#
# 结果格式如下所示。

