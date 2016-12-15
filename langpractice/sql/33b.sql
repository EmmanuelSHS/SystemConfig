DELETE FROM course
WHERE course_id NOT IN (SELECT course_in FROM section);
