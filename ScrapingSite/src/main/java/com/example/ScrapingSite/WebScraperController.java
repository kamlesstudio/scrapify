package com.example.ScrapingSite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ScrapingSite.service.UrlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
@Controller
@RequestMapping("/")
public class WebScraperController {
    @Autowired
    private UrlService urlService;
    @GetMapping("/scrape")
    public String scrape(Model model) {
        String url = "https://www.hindustantimes.com/latest-news";
        try{
                  // Connect to the URL and get the HTML content
            Document doc = Jsoup.connect(url).get();

            // Select the cartHolder div
            Element cartHolder = doc.selectFirst(".cartHolder");
            Element h3Tag = cartHolder.selectFirst("h3.hdg3");

        // Select the text of the <a> tag inside h3Tag
        String linkText = h3Tag.select("a").text();

        // Select the h2 tag with class "sortDesc" inside cartHolder
        Element h2Tag = cartHolder.selectFirst("h2.sortDec");

        // Get the text of h2Tag
        String headingText = h2Tag.text();

        // Select the div tag with class "secName" inside cartHolder
        Element divTag = cartHolder.selectFirst("div.secName");

        // Select the text of the <a> tag inside divTag
        String sectionName = divTag.select("a").text();
        // Element divtag2 = cartHolder.selectFirst("div.secTime");
        // String pubtime = divtag2.text();

        // Print the extracted content
        System.out.println("Link Text: " + linkText);
        System.out.println("Heading Text: " + headingText);
        System.out.println("Section Name: " + sectionName);
        // System.out.println("Section Name: " + divtag2);
        // System.out.println("Section Name: " + pubtime);

        Elements cartHolders = doc.select(".cartHolder");
        for (Element cartHolder1 : cartHolders) {
        Elements h3Tags1 = cartHolder1.select("h3.hdg3");
        String linkText1 = h3Tags1.select("a").text();
        System.out.println(linkText1);
        Element divtag2 = cartHolder.selectFirst("div.secTime");
        String pubtime = divtag2.text();
        // System.out.println("Section Name: " + divtag2);
        System.out.println("Section Name: " + pubtime);

        }
            // Select all child elements of the cartHolder div
            Elements childElements = cartHolder.children();

            // Iterate over the child elements and print their tags
            for (Element element : childElements) {
                System.out.println("Tag: " + element.tagName());
            }
        
    }catch (IOException e){
        e.printStackTrace();
    }
       
        // try {
        //     List<String> urls = urlService.getAllUrls(url);
        //     model.addAttribute("urls", urls);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
      
     
        return "scrape";
    }
}