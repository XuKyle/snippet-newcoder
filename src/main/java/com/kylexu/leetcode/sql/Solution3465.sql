# 在正则表达式中，\b 是一个元字符，表示“单词边界”。单词边界指的是单词的开始或结束位置，它用于确保匹配的是整个单词而不是单词的一部分。


select *
from products
where
#     (description regexp 'SN\\d{4}-\\d{4}\\s' or description regexp 'SN\\d{4}-\\d{4}$')
(description regexp 'SN\\d{4}-\\d{4}\\b')
order by product_id