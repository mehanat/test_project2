package ru.testproject2.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.testproject2.model.News;

import java.util.List;

/**
 * Created by Анатолий on 09.06.2016.
 */
@Repository
public class NewsDAOimpl implements NewsDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public NewsDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){ return sessionFactory.getCurrentSession(); }

    @Override
    public List<News> getList() {
        return currentSession().createQuery("FROM News").list();
    }

    @Override
    public News get(int id) {
        return currentSession().get(News.class, id);
    }

    @Override
    public News save(News news) {
        if (news.isNew()){
            news.setId((Integer) currentSession().save(news));
        } else {
            currentSession().update(news);
        }
        return news;
    }

    @Override
    public void delete(int id) {
        currentSession().createQuery("DELETE FROM News WHERE id=:id").setInteger("id", id).executeUpdate();
    }
}
