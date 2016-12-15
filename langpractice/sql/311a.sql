SELECT 	DISTINCT(name)
FROM	(SELECT COUNT(dept_name) AS c, name, ID
	FROM 	(student JOIN takes USING(ID))
	WHERE 	dept_name = 'Comp. Sci.'
	GROUP BY	ID)
WHERE	c > 1;
