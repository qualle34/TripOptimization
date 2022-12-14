DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS "user_login" CASCADE;
DROP TABLE IF EXISTS "credentials" CASCADE;
DROP TABLE IF EXISTS "role" CASCADE;
DROP TABLE IF EXISTS "gender" CASCADE;
DROP TABLE IF EXISTS "contact" CASCADE;
DROP TABLE IF EXISTS "department" CASCADE;
DROP TABLE IF EXISTS "passport" CASCADE;
DROP TABLE IF EXISTS "member" CASCADE;
DROP TABLE IF EXISTS "trip" CASCADE;
DROP TABLE IF EXISTS "ticket" CASCADE;
DROP TABLE IF EXISTS "transport" CASCADE;
DROP TABLE IF EXISTS "country" CASCADE;
DROP TABLE IF EXISTS "allowance" CASCADE;
DROP TABLE IF EXISTS "member_allowance" CASCADE;

CREATE TABLE "credentials"
(
    "user_id"  bigserial PRIMARY KEY,
    "login"    varchar,
    "password" varchar
);

CREATE TABLE "user"
(
    "id"            bigserial PRIMARY KEY,
    "name"          varchar,
    "surname"       varchar,
    "patronymic"    varchar,
    "birthday"      varchar,
    "role_id"       int8,
    "gender_id"     int8,
    "department_id" int8
);

CREATE TABLE "role"
(
    "id"    bigserial PRIMARY KEY,
    "value" varchar
);

CREATE TABLE "gender"
(
    "id"         bigserial PRIMARY KEY,
    "value"      varchar,
    "full_value" varchar
);

CREATE TABLE "contact"
(
    "id"      bigserial PRIMARY KEY,
    "user_id" int8,
    "value"   varchar,
    "type"    varchar
);

CREATE TABLE "department"
(
    "id"          bigserial PRIMARY KEY,
    "name"        varchar,
    "description" varchar
);

CREATE TABLE "passport"
(
    "user_id"         bigserial PRIMARY KEY,
    "serial"          varchar,
    "number"          int8,
    "personal_number" int8
);

CREATE TABLE "member"
(
    "id"      bigserial PRIMARY KEY,
    "user_id" int8,
    "trip_id" int8,
    "role"    varchar
);

CREATE TABLE "trip"
(
    "id"          bigserial PRIMARY KEY,
    "title"       varchar,
    "place"       varchar,
    "description" varchar,
    "date_start"  timestamp,
    "date_end"    timestamp,
    "expenses"    float8
);

CREATE TABLE "ticket"
(
    "id"        bigserial PRIMARY KEY,
    "member_id" int8,
    "from"      varchar,
    "to"        varchar,
    "date"      timestamp,
    "price"     float8,
    "type_id"   int8
);

CREATE TABLE "transport"
(
    "id"    bigserial PRIMARY KEY,
    "value" varchar
);

CREATE TABLE "country"
(
    "id"    bigserial PRIMARY KEY,
    "value" varchar
);

CREATE TABLE "allowance"
(
    "id"         bigserial PRIMARY KEY,
    "value"      float8,
    "country_id" int8
);

CREATE TABLE "member_allowance"
(
    "member_id"    int8,
    "allowance_id" int8,
    "days"         int4
);

CREATE TABLE "user_login"
(
    "id"      bigserial PRIMARY KEY,
    "user_id" int8,
    "date"    timestamp,
    "success" varchar
);

ALTER TABLE "member_allowance"
    ADD FOREIGN KEY ("member_id") REFERENCES "member" ("id");

ALTER TABLE "member_allowance"
    ADD FOREIGN KEY ("allowance_id") REFERENCES "allowance" ("id");

ALTER TABLE "member"
    ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "member"
    ADD FOREIGN KEY ("trip_id") REFERENCES "trip" ("id");

ALTER TABLE "credentials"
    ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "passport"
    ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "user"
    ADD FOREIGN KEY ("department_id") REFERENCES "department" ("id");

ALTER TABLE "user"
    ADD FOREIGN KEY ("role_id") REFERENCES "role" ("id");

ALTER TABLE "user"
    ADD FOREIGN KEY ("gender_id") REFERENCES "gender" ("id");

ALTER TABLE "contact"
    ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "ticket"
    ADD FOREIGN KEY ("type_id") REFERENCES "transport" ("id");

ALTER TABLE "ticket"
    ADD FOREIGN KEY ("member_id") REFERENCES "member" ("id");

ALTER TABLE "allowance"
    ADD FOREIGN KEY ("country_id") REFERENCES "country" ("id");

ALTER TABLE "user_login"
    ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

