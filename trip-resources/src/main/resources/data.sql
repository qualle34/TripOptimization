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

INSERT INTO country(value) values('Belarus');
INSERT INTO country(value) values('USA');
INSERT INTO country(value) values('Russia');
INSERT INTO country(value) values('Poland');
INSERT INTO country(value) values('England');
INSERT INTO country(value) values('Japan');

INSERT INTO transport(value) values('BUS');
INSERT INTO transport(value) values('TRAIN');
INSERT INTO transport(value) values('PLANE');
INSERT INTO transport(value) values('CAR');
INSERT INTO transport(value) values('TAXI');

INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(1, 'Уругвай, Тверь', 'Румыния, Саратов', '2023-01-13 05:20:58-00', 325, 1);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(2, 'Парагвай, Пенза', 'Мавритания, Пермь', '2019-06-30 17:58:55-00', 531, 2);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(3, 'Антильские Острова (не признана), Барнаул', 'Израиль, Пермь', '2017-11-11 06:39:12-00', 282, 2);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(4, 'Гайана, Липецк', 'Казахстан, Оренбург', '2019-09-15 14:13:52-00', 197, 3);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(1, 'Япония, Ульяновск', 'Уругвай, Нижний Новгород', '2023-04-15 06:45:45-00', 415, 4);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(2, 'Япония, Красноярск', 'Республика Конго, Тверь', '2023-05-01 07:42:35-00', 338, 5);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(3, 'Гана, Тула', 'Таиланд, Саратов', '2018-02-05 04:00:31-00', 540, 4);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(4, 'Саудовская Аравия, Владивосток', 'Гамбия, Киров', '2018-12-06 04:25:42-00', 657, 1);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(1, 'Мексика, Ижевск', 'Украина, Киров', '2022-10-25 02:30:37-00', 13, 2);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(2, 'Монако, Тула', 'Словения, Тверь', '2023-05-14 20:11:20-00', 689, 3);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(3, 'Финляндия, Томск', 'Тайвань (не признана), Новосибирск', '2017-05-19 22:58:23-00', 364, 4);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(4, 'Гвинея, Омск', 'Исландия, Волгоград', '2024-02-21 05:05:52-00', 218, 4);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(1, 'Тувалу, Ростов-на-Дону', 'Италия, Омск', '2024-08-26 06:43:55-00', 8, 1);
INSERT INTO ticket(member_id, "from", "to", date, price, type_id) values(2, 'Гондурас, Волгоград', 'Демократическая Республика, Томск', '2021-06-15 08:57:31-00', 113, 2);