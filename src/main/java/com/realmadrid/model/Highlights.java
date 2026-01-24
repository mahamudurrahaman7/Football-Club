package com.realmadrid.model;

import org.springframework.data.annotation.Id;

public class Highlights {

    @Id
    private String id;
    private String highlightsId;
    private String title;
    private String video;
    private String date;


    public Highlights() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHighlightsId() {
        return highlightsId;
    }

    public void setHighlightsId(String highlightsId) {
        this.highlightsId = highlightsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

