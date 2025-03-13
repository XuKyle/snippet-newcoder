select *
from Scores;
# 编写一个解决方案来查找 进步的学生。如果 同时 满足以下两个条件，则该学生被认为是进步的：
#
# 在 同一科目 至少参加过两个不同日期的考试。
# 他们在该学科 最近的分数 比他们 第一次该学科考试的分数更高。
# 返回结果表以 student_id，subject 升序 排序。
#
# 结果格式如下所示。
#
# +------------+----------+-------------+--------------+
# | student_id | subject  | first_score | latest_score |
# +------------+----------+-------------+--------------+
# | 101        | Math     | 70          | 85           |
# | 102        | Math     | 80          | 85           |
# | 104        | Physics  | 75          | 85           |
# +------------+----------+-------------+--------------+

with gm as (select *,
                   row_number() over (partition by student_id,subject order by exam_date) as rk,
                   count(*) over (partition by student_id,subject)                        as cnt
            from Scores)
select a.student_id, a.subject, b.score as first_score, a.score as latest_score
from gm a
         join gm b on a.student_id = b.student_id and a.subject = b.subject
where a.cnt > 1
  and a.cnt = a.rk
  and b.rk = 1
  and a.score > b.score
order by a.student_id, a.subject