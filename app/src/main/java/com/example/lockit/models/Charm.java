package com.example.lockit.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Charm")
public class Charm extends ParseObject {

    public static final String KEY_USER = "user";
    public static final String KEY_ORG_NAME = "orgName";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_PASSWORD = "password";

    public Charm() { }

    // Getter methods
    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public String getOrgName() {
        return getString(KEY_ORG_NAME);
    }

    public String getUserName() {
        return getString(KEY_USER_NAME);
    }

    public String getPassword() {
        return getString(KEY_PASSWORD);
    }

    // Setter methods
    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public void setOrgName(String orgName) {
        put(KEY_ORG_NAME, orgName);
    }

    public void setUserName(String username) {
        put(KEY_USER_NAME, username);
    }

    public void setPassword(String password) {
        put(KEY_PASSWORD, password);
    }
}