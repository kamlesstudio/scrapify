package com.example.ScrapingSite.controller;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ScrapingSite.model.NewsBuilder;
import com.example.ScrapingSite.service.NewsBuilderService;

@Controller
@RequestMapping("/")
public class NewsBuilderController {
    @Autowired
    private NewsBuilderService newsBuilderService;
    @GetMapping("/htitems")
    public String scrape(Model model) {
        String url = "https://www.hindustantimes.com/latest-news";
        String websiteUrl = url;
        String domainName = "www.hindustantimes.com";
        try{
            Document doc = Jsoup.connect(url).get();
              Elements cartHolders = doc.select(".cartHolder");

              for (Element cartHolder : cartHolders) {
                Elements h3Tags = cartHolder.select("h3.hdg3");
                String href_attr = h3Tags.select("a").attr("href");
                
                String href_text = h3Tags.select("a").text();
                String links = "https://www.hindustantimes.com/" + href_attr;

                Element divtag = cartHolder.selectFirst("div.secTime");
                String publish = divtag.text();
                Element divTag = cartHolder.selectFirst("div.secName");

            
                String content = divTag.select("a").text();

                System.out.println(href_attr);
                System.out.println("Section Name: " + publish);
                System.out.println("href_text" + href_text);
                System.out.println("href_text" + href_attr);
      
            NewsBuilder savedNews = newsBuilderService.saveNews(websiteUrl, links, domainName, href_attr, href_text, publish, content);
           
        }
        model.addAttribute("message", "Data saved successfully");
       
        
    }
        catch(IOException e){
            model.addAttribute("error", "Failed to fetch data");
            e.printStackTrace();
            
    }
    return "one";

    }

    @GetMapping("/all-news")
    public String getAllNews(Model model) {
    List<NewsBuilder> newsList = newsBuilderService.getAllNews();
    model.addAttribute("news", newsList);
    return "posting"; // Assuming you have a Thymeleaf template named "all-news.html"
}
   
}

