package com.realmadrid.model;

import org.springframework.data.annotation.Id;

public class Result {
    @Id
    private String id;
    private String opponentName;
    private int ourScore;
    private int TheirScore;
    private String venueType;



    public Result() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public void setOpponentName(String opponentName) {
        this.opponentName = opponentName;
    }

    public int getOurScore() {
        return ourScore;
    }

    public void setOurScore(int ourScore) {
        this.ourScore = ourScore;
    }

    public int getTheirScore() {
        return TheirScore;
    }

    public void setTheirScore(int theirScore) {
        TheirScore = theirScore;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }
}
