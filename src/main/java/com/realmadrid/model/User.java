package com.realmadrid.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    private String id;



    private String name;
    private String email;
    private String password;
    private String birthday;
    private String supportSince;
    private String country;
    private String favouritePlayer;

    private List<String> roleList = new ArrayList<>();


    public User() {
    }

    public User(String id, String name, String email,
                String password, String birthday, String supportSince,
                String country, String favouritePlayer,
                List<String> roleList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.supportSince = supportSince;
        this.country = country;
        this.favouritePlayer = favouritePlayer;
        this.roleList = roleList;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSupportSince() {
        return supportSince;
    }

    public void setSupportSince(String supportSince) {
        this.supportSince = supportSince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouritePlayer() {
        return favouritePlayer;
    }

    public void setFavouritePlayer(String favouritePlayer) {
        this.favouritePlayer = favouritePlayer;
    }
}
