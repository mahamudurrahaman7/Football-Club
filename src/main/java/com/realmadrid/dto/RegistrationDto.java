package com.realmadrid.dto;

import java.time.LocalDate;

public class RegistrationDto {

    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private boolean alreadyExists;
    private String country;
    private LocalDate supportSince;
    private String favouritePlayer;


    public RegistrationDto() {
    }

    public RegistrationDto(String name, String email, String password, LocalDate birthDate, boolean alreadyExists, String country, LocalDate supportSince, String favouritePlayer) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.alreadyExists = alreadyExists;
        this.country = country;
        this.supportSince = supportSince;
        this.favouritePlayer = favouritePlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAlreadyExists() {
        return alreadyExists;
    }

    public void setAlreadyExists(boolean alreadyExists) {
        this.alreadyExists = alreadyExists;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getSupportSince() {
        return supportSince;
    }

    public void setSupportSince(LocalDate supportSince) {
        this.supportSince = supportSince;
    }

    public String getFavouritePlayer() {
        return favouritePlayer;
    }

    public void setFavouritePlayer(String favouritePlayer) {
        this.favouritePlayer = favouritePlayer;
    }
}
