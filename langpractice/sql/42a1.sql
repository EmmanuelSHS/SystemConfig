SELECT *
FROM (student JOIN takes USING(ID))
UNION
SELECT ID, name, dept_name, tot_cred, NULL, NULL, NULL, NULL, NULL
FROM student s1
WHERE NOT EXISTS 
(SELECT tk.ID FROM takes tk WHERE tk.ID = s1.ID);
