package com.example.ScrapingSite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ScrapingSite.model.NewsBuilder;
import com.example.ScrapingSite.repository.NewsBuilderRepository;

@Service
public class NewsBuilderService {

    @Autowired
    private NewsBuilderRepository newsBuilderRepository;

    public NewsBuilder saveNews(String websiteUrl, String links, String domainName, String hrefAttr, String hrefText, String publish, String content) {
        NewsBuilder newsBuilder = new NewsBuilder();
        newsBuilder.setWebsiteUrl(websiteUrl);
        newsBuilder.setLinks(links);
        newsBuilder.setDomain(domainName);
        newsBuilder.setHrefAttr(hrefAttr);
        newsBuilder.setHrefText(hrefText);
        newsBuilder.setPublish(publish);
        newsBuilder.setContent(content);
        

        return newsBuilderRepository.save(newsBuilder);
    }

    public List<NewsBuilder> getAllNews() {
        return newsBuilderRepository.findAll();
    }
}
