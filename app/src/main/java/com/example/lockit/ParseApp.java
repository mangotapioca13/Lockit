package com.example.lockit;

import android.app.Application;

import com.example.lockit.models.Charm;
import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Charm.class);
        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("lockit")
                .clientKey("lockit08122019")
                .server("http://lockit-jelly.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);
    }
}