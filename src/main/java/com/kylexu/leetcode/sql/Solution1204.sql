# person_id 是这个表具有唯一值的列。
# 该表展示了所有候车乘客的信息。
# 表中 person_id 和 turn 列将包含从 1 到 n 的所有数字，其中 n 是表中的行数。
# turn 决定了候车乘客上巴士的顺序，其中 turn=1 表示第一个上巴士，turn=n 表示最后一个上巴士。
# weight 表示候车乘客的体重，以千克为单位。
#
#
# 有一队乘客在等着上巴士。然而，巴士有1000  千克 的重量限制，所以其中一部分乘客可能无法上巴士。
#
# 编写解决方案找出 最后一个 上巴士且不超过重量限制的乘客，并报告 person_name 。题目测试用例确保顺位第一的人可以上巴士且不会超重。
#
# 返回结果格式如下所示。
#
with stat_info as (
    select
        person_id,person_name,
        weight,
        sum(weight) over(order by  turn) as total_weight
    from Queue
),
     rk_info as (
         select
             person_name,row_number() over (order by  total_weight desc) as rk
         from stat_info
         where total_weight <=1000
     )
select person_name from rk_info
where rk = 1



#
# 示例 1：
#
# 输入：
# Queue 表
# +-----------+-------------+--------+------+
# | person_id | person_name | weight | turn |
# +-----------+-------------+--------+------+
# | 5         | Alice       | 250    | 1    |
# | 4         | Bob         | 175    | 5    |
# | 3         | Alex        | 350    | 2    |
# | 6         | John Cena   | 400    | 3    |
# | 1         | Winston     | 500    | 6    |
# | 2         | Marie       | 200    | 4    |
# +-----------+-------------+--------+------+
# 输出：
# +-------------+
# | person_name |
# +-------------+
# | John Cena   |
# +-------------+
# 解释：
# 为了简化，Queue 表按 turn 列由小到大排序。
# +------+----+-----------+--------+--------------+
# | Turn | ID | Name      | Weight | Total Weight |
# +------+----+-----------+--------+--------------+
# | 1    | 5  | Alice     | 250    | 250          |
# | 2    | 3  | Alex      | 350    | 600          |
# | 3    | 6  | John Cena | 400    | 1000         | (最后一个上巴士)
# | 4    | 2  | Marie     | 200    | 1200         | (无法上巴士)
# | 5    | 4  | Bob       | 175    | ___          |
# | 6    | 1  | Winston   | 500    | ___          |
# +------+----+-----------+--------+--------------+