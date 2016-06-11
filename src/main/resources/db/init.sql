DROP TABLE news;
DROP TABLE categories;
DROP TABLE news_categories;

CREATE TABLE news(
  id SERIAL PRIMARY KEY,
  headline VARCHAR(40) NOT NULL,
  content VARCHAR(500) NOT NULL,
  date DATE DEFAULT now()
);

CREATE TABLE categories(
  id SERIAL PRIMARY KEY,
  name VARCHAR(20)
);

CREATE TABLE news_categories(
  news_id INT REFERENCES news(id) ON DELETE CASCADE ,
  category_id INT REFERENCES categories(id) ON DELETE CASCADE
);