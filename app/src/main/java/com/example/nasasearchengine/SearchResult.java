package com.example.nasasearchengine;

public class SearchResult {
    String title;
    String image;
    String description;
    String date;

    public SearchResult(String title, String image, String description, String date) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
