package ru.testproject2.util;

import org.hibernate.validator.constraints.NotEmpty;
import ru.testproject2.model.Category;
import ru.testproject2.model.News;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Анатолий on 10.06.2016.
 */
public class NewsTO {
    private int id;
    @NotNull
    @Size(max = 40)
    private String headline;
    @NotNull
    @Size(max = 500)
    private String content;
    @NotNull
    @Size(min = 1)
    private List<Integer> catIDs;

    public NewsTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<Integer> getCatIDs() {
        return catIDs;
    }

    public void setCatIDs(List<Integer> catIDs) {
        this.catIDs = catIDs;
    }

    public News toNews(){
        News news=new News();
        news.setId(id);
        news.setHeadline(headline);
        news.setContent(content);
        if (catIDs!=null&&catIDs.size()>0){
            List<Category> categories = new ArrayList<>();
            for (Integer id : catIDs) {
                categories.add(new Category(id, null));
            }
            news.setCategories(categories);
        }
        return news;
    }
}
