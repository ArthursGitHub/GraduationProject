DROP TABLE IF EXISTS cafe;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS vote;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE cafe
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX cafe_unique_name_idx ON cafe (name);

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL
);
CREATE UNIQUE INDEX user_unique_name_idx ON users (name);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR
);

CREATE TABLE meals
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  price INTEGER DEFAULT 2000    NOT NULL,
  date_time   TIMESTAMP NOT NULL,
  cafe_id     INTEGER   NOT NULL
);

CREATE TABLE vote
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER   NOT NULL,
  cafe_id     INTEGER   NOT NULL,
  date_time   TIMESTAMP NOT NULL
);
