INSERT INTO	instructor
SELECT		ID, name, dept_name, 10000
FROM		student
WHERE		tot_cred > 100;
