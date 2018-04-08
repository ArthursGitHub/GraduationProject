DELETE FROM cafe;
DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM vote;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO cafe (name) VALUES
  ('Взлет'),
  ('Звездочка'),
  ('Молодежное');

INSERT INTO users (name) VALUES
  ('Admin'),
  ('User1'),
  ('User2'),
  ('User3');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100003),
  ('ROLE_USER', 100004),
  ('ROLE_USER', 100005),
  ('ROLE_USER', 100006);

INSERT INTO meals (date, name, price, cafe_id) VALUES
  ('2015-05-21', '1. Суп овощной', 90, 100000),
  ('2015-05-22', '1. Суп гороховый', 90, 100000),
  ('2015-05-23', '1. Борщ', 90, 100000),
  ('2015-05-21', '1. Рассольник', 90, 100001),
  ('2015-05-22', '1. Молочный суп', 90, 100001),
  ('2015-05-23', '1. Грибной суп', 90, 100001),
  ('2015-05-21', '1. Похлебка', 90, 100002),
  ('2015-05-22', '1. Солянка', 90, 100002),
  ('2015-05-23', '1. Рыбный суп', 90, 100002),
  ('2015-05-24', '1. Суп с фрикадельками', 90, 100002),

  ('2015-05-21', '2. Макароны с мясом', 70, 100000),
  ('2015-05-22', '2. Картошка с мясом', 150, 100000),
  ('2015-05-23', '2. Пицца', 90, 100000),
  ('2015-05-21', '2. Тушеное мясо в горшочке', 80, 100001),
  ('2015-05-22', '2. Куриное филе', 80, 100001),
  ('2015-05-23', '2. Горбуша в духовке', 80, 100001),
  ('2015-05-21', '2. Котлеты с гречей', 80, 100002),
  ('2015-05-22', '2. Макароны с сосисками', 80, 100002),
  ('2015-05-23', '2. Яичница', 80, 100002),
  ('2015-05-24', '2. Пельмени', 80, 100002),

  ('2015-05-21', '3. Морс', 50, 100000),
  ('2015-05-22', '3. Какао', 50, 100000),
  ('2015-05-23', '3. Молоко', 50, 100000),
  ('2015-05-21', '3. Сбитень', 50, 100001),
  ('2015-05-22', '3. Глинтвейн', 50, 100001),
  ('2015-05-23', '3. Лимонад', 50, 100001),
  ('2015-05-21', '3. Кисель', 50, 100002),
  ('2015-05-22', '3. Чай', 50, 100002),
  ('2015-05-23', '3. Сок', 60, 100002),
  ('2015-05-24', '3. Кампот', 50, 100002);

INSERT INTO vote (user_id, cafe_id, date_time) VALUES
  (100000, 100011, '2015-05-31');
