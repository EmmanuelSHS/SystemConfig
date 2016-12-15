SELECT count(ID), takes.course_id, takes.sec_id
FROM (student JOIN takes USING(ID))
WHERE takes.year = 2009 AND takes.semester = 'Fall'
GROUP BY course_id, sec_id;
