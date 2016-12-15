SELECT	MAX(grades), ID, name
FROM	(SELECT	SUM(grade) AS grades, ID, name
	FROM	(student JOIN takes USING(ID))
	GROUP BY	ID);
