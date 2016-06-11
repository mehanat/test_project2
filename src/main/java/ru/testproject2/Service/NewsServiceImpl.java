package ru.testproject2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject2.DAO.NewsDAO;
import ru.testproject2.model.News;

import java.util.List;

/**
 * Created by Анатолий on 09.06.2016.
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsDAO newsDAO;

    @Override
    public List<News> getList() {
        return newsDAO.getList();
    }

    @Override
    public News get(int id) {
        return newsDAO.get(id);
    }

    @Override
    public News save(News news) {
        return newsDAO.save(news);
    }

    @Override
    public void delete(int id) {
        newsDAO.delete(id);
    }
}
