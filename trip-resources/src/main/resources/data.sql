INSERT INTO "role"(value) values('GUEST');
INSERT INTO "role"(value) values('USER');
INSERT INTO "role"(value) values('MANAGER');
INSERT INTO "role"(value) values('ADMIN');

INSERT INTO "department"(name, description) values('RIA', 'Rich Internet Applications');

INSERT INTO "user"(name, surname, patronymic, birthday, gender, role_id, department_id) values('Андрей', 'Фролов', 'Панович', '1981-05-22', 'M', 2, 1);

INSERT INTO "credentials"(user_id, login, password) values(1, 'user', 'pass');