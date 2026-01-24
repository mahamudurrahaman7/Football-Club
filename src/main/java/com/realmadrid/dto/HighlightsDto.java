package com.realmadrid.dto;

import java.time.LocalDate;

public class HighlightsDto {

    private String highlightsId;
    private String title;
    private String video;
    private LocalDate date;
    private boolean isPresent;
    private boolean savedSuccessfully;

    public HighlightsDto() {
    }



    public boolean isSavedSuccessfully() {
        return savedSuccessfully;
    }

    public void setSavedSuccessfully(boolean savedSuccessfully) {
        this.savedSuccessfully = savedSuccessfully;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean present) {
        isPresent = present;
    }
}
