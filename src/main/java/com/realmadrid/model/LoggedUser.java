package com.realmadrid.model;

public class LoggedUser {
    public static User loggedInUser = null;

    public LoggedUser() {
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        LoggedUser.loggedInUser = loggedInUser;
    }
}
