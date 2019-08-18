package com.example.lockit.models;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Charm")
public class Charm extends ParseObject {

    public static final String KEY_USR = "user";
    public static final String KEY_ORG_NAME = "orgName";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_PASSWORD = "password";

    public Charm() { }
}