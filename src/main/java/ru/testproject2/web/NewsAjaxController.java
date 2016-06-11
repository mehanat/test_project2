package ru.testproject2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.testproject2.Service.NewsService;
import ru.testproject2.model.News;
import ru.testproject2.util.NewsTO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Анатолий on 09.06.2016.
 */
@RestController
@RequestMapping(value = "ajax")
public class NewsAjaxController {

    @Autowired
    NewsService newsService;

    @RequestMapping(value = "news", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<News> getNewsList(){
        return newsService.getList();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded", consumes = "application/json;charset=UTF-8")
    public Map<String, String> saveNews(@Valid NewsTO newsTO, BindingResult result, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Map<String, String> errors=new HashMap<>();
        if (result.hasErrors()){

            result.getFieldErrors().forEach(error->errors.put(error.getField(), error.getDefaultMessage()));
            request.setAttribute("errors", errors);
        } else {
        newsService.save(newsTO.toNews());
        response.sendRedirect("/");
        }
        return errors;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteNews(@PathVariable int id){
        newsService.delete(id);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public News getNews(@PathVariable int id){
        return newsService.get(id);
    }
}
