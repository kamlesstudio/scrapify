package com.example.ScrapingSite.model;

public class ScrapedContent {
    private String url;
    private String content;

    public ScrapedContent(String url, String content) {
        this.url = url;
        this.content = content;
    }

    // Getters and setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

