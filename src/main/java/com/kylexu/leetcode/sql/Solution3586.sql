-- 编写一个解决方案以找到从 COVID 中康复的患者——那些曾经检测呈阳性但后来检测呈阴性的患者。
--
-- 患者如果 至少有一次阳性 检测结果后，在 之后的日期 至少有一次 阴性 检测结果，则被认为已康复。
-- 计算从 首次阳性检测 结果到 该阳性检测 后的 首次阴性检测结果 之间的 康复时间（以天为单位）
-- 仅包括 同时具有阳性及阴性检测结果的患者
-- 返回结果表以 recovery_time 升序 排序，然后以 patient_name 升序 排序。


with first_positive as (select patient_id, min(test_date) as first_positive_date, min(test_id) as first_positive_test_id
                        from covid_tests
                        where result in ('Positive')
                        group by patient_id)
   , first_negative_after_positive as (select a.*, row_number() over (partition by a.patient_id order by a.test_date) as first_negative
                                       from covid_tests a
                                                join first_positive b on a.patient_id = b.patient_id
                                       where a.result in ('Negative')
                                         and a.test_date > b.first_positive_date)

select a.patient_id,
       d.patient_name,
       d.age,
       datediff(c.test_date, a.test_date) as recovery_time
from covid_tests a
         join first_positive b on a.test_id = b.first_positive_test_id and a.patient_id = b.patient_id
         join first_negative_after_positive c on a.patient_id = c.patient_id
         join patients d on a.patient_id = d.patient_id
where a.result = 'Positive'
  and c.first_negative = 1
order by datediff(c.test_date, a.test_date), d.patient_name