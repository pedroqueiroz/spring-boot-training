INSERT INTO USER(name, email, password) VALUES('Student', 'student@email.com', '$2a$10$xYn9ze8j.CyH/xu8aTU1qeypnEhpGDTtZ5mBCAeK.e5W9gIUBQ.Ru');

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Frontend');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 1', 'Error on project creation', '2019-05-05 18:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 2', 'Project will not compile', '2019-05-05 19:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 3', 'HTML Tag', '2019-05-05 20:00:00', 'UNANSWERED', 1, 2);