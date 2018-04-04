
-- DELETE FROM user_roles;
DELETE FROM meals;
-- DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;
/*
INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);
*/
INSERT INTO meals (date_time, name, price, cafe_id) VALUES
  ('2015-05-30 00:00:00', 'Блинчик', 70, 100000),
  ('2015-05-30 00:00:00', 'Суп овощной', 90, 100000),
  ('2015-05-30 00:00:00', 'Картошка с мясом', 150, 100000),
  ('2015-05-31 00:00:00', 'Борщ', 90, 100000),
  ('2015-05-31 00:00:00', 'Кампот', 50, 100000),
  ('2015-05-31 00:00:00', 'Сок', 60, 100000),
  ('2015-06-01 00:00:00', 'Макароны', 80, 100001),
  ('2015-06-01 00:00:00', 'Хлеб', 5, 100001);

