package com.realmadrid.model;

import org.springframework.data.annotation.Id;

public class Player {
    @Id
    private String id;
    private String playerId;
    private String playerName;
    private String jerseyNumber;
    private String height;
    private String weight;
    private int goals;
    private String country;
    private String dateOfBirth;
    private String inTheClubSince;
    private String contractEnds;
    private String image;
    private String foot;
    private String position;

    public Player() {
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInTheClubSince() {
        return inTheClubSince;
    }

    public void setInTheClubSince(String inTheClubSince) {
        this.inTheClubSince = inTheClubSince;
    }

    public String getContractEnds() {
        return contractEnds;
    }

    public void setContractEnds(String contractEnds) {
        this.contractEnds = contractEnds;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
