package com.example.ScrapingSite.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
@Service
public class UrlService {

    public List<String> getAllUrls(String url) throws IOException {
        List<String> urls = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements linkElements = doc.select("a[href]");
        linkElements.forEach(link -> urls.add(link.attr("abs:href")));
        return urls;
    }
}
