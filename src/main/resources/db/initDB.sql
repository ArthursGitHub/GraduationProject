DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cafe;
DROP TABLE IF EXISTS vote;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE meals
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  price INTEGER DEFAULT 2000    NOT NULL,
  date_time   TIMESTAMP NOT NULL,
  cafe_id     INTEGER   NOT NULL
);

CREATE TABLE cafe
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL
);

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL
);

-- CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role)
--   FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE vote
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER   NOT NULL,
  cafe_id     INTEGER   NOT NULL,
  date_time   TIMESTAMP NOT NULL
);

/*
CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER   NOT NULL,
  date_time   TIMESTAMP NOT NULL,
  description TEXT      NOT NULL,
  calories    INT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals (user_id, date_time);
*/
