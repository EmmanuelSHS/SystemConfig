SELECT DISTINCT student.ID
FROM (student JOIN takes USING(ID)) 
JOIN (instructor JOIN teaches USING(ID)) 
USING (course_id, sec_id, semester, year)
WHERE instructor.name = 'Einstein'; 
