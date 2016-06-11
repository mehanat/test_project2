DELETE FROM news;
DELETE FROM categories;
DELETE FROM news_categories;

ALTER SEQUENCE categories_id_seq RESTART;
ALTER SEQUENCE news_id_seq RESTART ;

INSERT INTO news(headline, content, date) VALUES
  ('Выборы нового главы минразвития', 'В эту субботу состоялись выборы нового главы минэкономразвития', '09.06.2016'),
  ('Падение курса рубля', 'В связи с новыми санкциями курс российского рубля продолжает падение', '10.05.2015'),
  ('Новость3', 'Содержание 3', '10.06.2015'),
  ('Новость 4', 'Содержание 4', '10.07.2015'),
  ('Новость 5', 'Содержание 5', '10.08.2015');

INSERT INTO categories(name) VALUES ('Политика'), ('Экономика'), ('Спорт');

INSERT INTO news_categories VALUES (1, 1), (2, 1), (2, 2), (3, 3), (4, 2), (4,1), (5,3)