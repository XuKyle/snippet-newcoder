# (user_id, time_stamp)是该表的主键。
# user_id是一个引用到注册表的外键。
# action是类型为('confirmed'， 'timeout')的ENUM
# 该表的每一行都表示ID为user_id的用户在time_stamp请求了一条确认消息，该确认消息要么被确认('confirmed')，要么被过期('timeout')。
#
#
# 用户的 确认率 是 'confirmed' 消息的数量除以请求的确认消息的总数。没有请求任何确认消息的用户的确认率为 0 。确认率四舍五入到 小数点后两位 。
#
# 编写一个SQL查询来查找每个用户的 确认率 。

select * from Signups;
select  * From Confirmations;

select
    a.user_id,round(sum(if(b.action = 'confirmed',1,0))/count(*),2) as confirmation_rate
from
    Signups a left join Confirmations b on a.user_id = b.user_id
group by  a.user_id