INSERT INTO "role"(value) values('GUEST');
INSERT INTO "role"(value) values('USER');
INSERT INTO "role"(value) values('MANAGER');
INSERT INTO "role"(value) values('ADMIN');

INSERT INTO "department"(name, description) values('RIA', 'Rich Internet Applications');
INSERT INTO "department"(name, description) values('FRONT', 'Frontend developers');
INSERT INTO "department"(name, description) values('CLEANERS', 'Everything will be clean');
INSERT INTO "department"(name, description) values('SNIPER', 'A person who shoots from a hiding place, especially accurately and at long range.');
INSERT INTO "department"(name, description) values('ADMINS', 'CTRL+ALT+DEL');
INSERT INTO "department"(name, description) values('MANAGERS-1', 'Some text');

INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Андрей', 'Фролов', 'Панович', '1981-05-22', 'M', 2, 1);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Максим', 'Максимович', 'Максимов', '1945-05-22', 'M', 2, 2);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Дима', 'Максимович', 'Тестов', '1945-05-22', 'M', 2, 3);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Лена', 'Катева', 'Максимов', '1965-05-22', 'W', 3, 6);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Аня', 'Егоровна', 'Ленова', '1947-05-22', 'W', 3, 6);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Коля', 'Максимович', 'Котлин', '1993-05-22', 'M', 2, 4);
INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Admin', 'Admin', 'Admin', '2018-05-22', 'W', 4, 5);

INSERT INTO "credentials"(user_id, login, password) values(1, 'andry23154', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(2, 'slon', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(3, 'dimatank', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(4, 'elena22', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(5, 'annamanager', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(6, 'user', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe');
INSERT INTO "credentials"(user_id, login, password) values(7, 'admin', '$2a$10$dt1Jmg.w/sgjVSo2u7Vks.CD6wOGe2PqX.vB9uVPfVswyIeS99/46');

INSERT INTO trip(title, description, place, date_start, date_end, expenses) values('Farming', 'Test text: Iolaus', 'Самара', '2017-01-02 22:05:41-00', '2021-12-14 15:23:55-00', 236);
INSERT INTO trip(title, description, place, date_start, date_end, expenses) values('Construction', 'Test text: Phaedra', 'Магнитогорск', '2017-04-05 22:18:03-00', '2025-06-04 00:54:21-00', 180);
INSERT INTO trip(title, description, place, date_start, date_end, expenses) values('Manufacturing', 'Test text: Ariadne', 'Тверь', '2020-12-21 04:37:51-00', '2023-12-13 10:36:04-00', 158);
INSERT INTO trip(title, description, place, date_start, date_end, expenses) values('Legal', 'Test text: Atalanta', 'Самара', '2018-01-14 04:32:38-00', '2023-07-25 20:49:43-00', 23);


INSERT INTO member(user_id, trip_id, role) values(6, 1, 'Product Administrator');
INSERT INTO member(user_id, trip_id, role) values(6, 2, 'Direct Technician');
INSERT INTO member(user_id, trip_id, role) values(6, 3, 'Construction Engineer');
INSERT INTO member(user_id, trip_id, role) values(6, 4, 'Engineer');