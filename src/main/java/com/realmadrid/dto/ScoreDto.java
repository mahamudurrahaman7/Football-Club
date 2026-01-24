package com.realmadrid.dto;

public class ScoreDto {
    private int ourScore;
    private int theirScore;
    private boolean admin = true;



    public ScoreDto() {
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getOurScore() {
        return ourScore;
    }

    public void setOurScore(int ourScore) {
        this.ourScore = ourScore;
    }

    public int getTheirScore() {
        return theirScore;
    }

    public void setTheirScore(int theirScore) {
        this.theirScore = theirScore;
    }
}
