SELECT *
FROM student JOIN takes USING(ID)
UNION
SELECT s1.ID, s1.name, s1.dept_name, s1.tot_cred, NULL, NULL, NULL, NULL, NULL
FROM student s1
WHERE NOT EXISTS (SELECT ID FROM takes t WHERE t.ID = s1.ID)
UNION
SELECT ID, NULL, NULL, NULL, course_id, sec_id, semester, year, grade
FROM takes t1
WHERE NOT EXISTS (SELECT ID FROM student s WHERE s.ID = t1.ID);
