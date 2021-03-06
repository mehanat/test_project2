package ru.testproject2.DAO;

import ru.testproject2.model.News;

import java.util.List;

/**
 * Created by Анатолий on 09.06.2016.
 */
public interface NewsDAO {
    List<News> getList();
    News get(int id);
    News save(News news);
    void delete(int id);
}
