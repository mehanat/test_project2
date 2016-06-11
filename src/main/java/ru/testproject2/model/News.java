package ru.testproject2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Анатолий on 09.06.2016.
 */
@Entity
@Table(name = "news")
public class News extends BasedEntity {

    @Column(name = "headline")
    private String headline;

    @Column(name = "content")
    private String content;

    @Column(name = "date", updatable = false)
    private Date date=new Date();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "news_categories", joinColumns = {@JoinColumn(name = "news_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories=new ArrayList<>();


    public News() {}

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
