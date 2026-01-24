package com.realmadrid.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class PlayerListDto {

    private String playerId;
    private String playerName;
    private String jerseyNumber;
    private String height;
    private String weight;
    private String goals;
    private String country;
    private LocalDate dateOfBirth;
    private LocalDate inTheClubSince;
    private LocalDate contractEnds;
    private String image;
    private String foot;
    private String position;
    private boolean isDeleted;
    private boolean isAdmin = true;

    public PlayerListDto() {
    }


    public boolean isAdmin() {
        return isAdmin;

    }



    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getInTheClubSince() {
        return inTheClubSince;
    }

    public void setInTheClubSince(LocalDate inTheClubSince) {
        this.inTheClubSince = inTheClubSince;
    }

    public LocalDate getContractEnds() {
        return contractEnds;
    }

    public void setContractEnds(LocalDate contractEnds) {
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
