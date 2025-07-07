WITH RECURSIVE cte (employee_id, employee_name, salary, level, label) AS
                   (SELECT employee_id, employee_name, salary, 1, concat(employee_id)
                    FROM Employees
                    WHERE manager_id IS NULL
                    UNION
                    SELECT e.employee_id, e.employee_name, e.salary, level + 1, concat(label, ',', e.employee_id)
                    FROM Employees e
                             JOIN cte ON e.manager_id = cte.employee_id)

SELECT c.employee_id, c.employee_name, c.level, count(1) - 1 team_size, sum(c1.salary) budget
FROM cte c
         JOIN cte c1 ON c1.label REGEXP concat('^', c.label, '\\b')
GROUP BY c.employee_id, c.employee_name, c.level
ORDER BY c.level, budget DESC, c.employee_name