

WITH t AS (
    SELECT p.user_id, p.product_id, i.category
    FROM productpurchases p
    LEFT JOIN productinfo i USING(product_id)
)
SELECT t1.category AS category1, t2.category AS category2,
       COUNT(DISTINCT t1.user_id) AS customer_count
FROM t t1
         JOIN t t2
              ON t1.user_id = t2.user_id AND t1.category < t2.category
GROUP BY t1.category, t2.category
HAVING COUNT(DISTINCT t1.user_id) >= 3
ORDER BY COUNT(DISTINCT t1.user_id) DESC, t1.category, t2.category