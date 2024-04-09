package com.example.ScrapingSite.model;
import jakarta.persistence.*;
@Entity
@Table(name = "newsextract")
public class NewsBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "website_url", nullable = false)
    private String websiteUrl;

    @Column(name = "links")
    private String links;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "href_attr")
    private String hrefAttr;

    @Column(name = "href_text")
    private String hrefText;

    @Column(name = "publish")
    private String publish;


    @Column(name = "content")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getDomain() {
        return domainName;
    }

    public void setDomain(String domainName) {
        this.domainName = domainName;
    }

    public String getHrefAttr() {
        return hrefAttr;
    }

    public void setHrefAttr(String hrefAttr) {
        this.hrefAttr = hrefAttr;
    }

    public String getHrefText() {
        return hrefText;
    }

    public void setHrefText(String hrefText) {
        this.hrefText = hrefText;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
