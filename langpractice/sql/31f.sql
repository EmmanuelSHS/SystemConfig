SELECT	MAX(enroll), course_id, sec_id
FROM	(SELECT COUNT(ID) AS enroll, course_id, sec_id
	FROM (student JOIN takes USING(ID))
	WHERE year = 2009 AND semester = 'Fall'
	GROUP BY course_id, sec_id);
