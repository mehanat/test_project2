package ru.testproject2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.testproject2.model.Category;
import ru.testproject2.model.News;
import ru.testproject2.util.NewsTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Анатолий on 09.06.2016.
 */
@Controller
@RequestMapping(value = "/")
public class RootController {

    @RequestMapping(value = "")
    public String mainPage(ModelMap modelMap){
        NewsTO news=new NewsTO();
        news.setCatIDs(new ArrayList<>());
        modelMap.addAttribute("news", news);
        return "main";
    }
}
