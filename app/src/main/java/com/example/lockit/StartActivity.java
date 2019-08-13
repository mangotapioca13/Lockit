// Angela Liu
// Lockit 08122019

package com.example.lockit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

public class StartActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ParseUser.logOut();
        ParseUser currUser = ParseUser.getCurrentUser();

        // If there is a current user, then bring them to their home
        // Else bring user to start page for login or create new account
        if (currUser != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            btnLogin = (Button) findViewById(R.id.btnLogin);
            btnCreate = (Button) findViewById(R.id.btnCreate);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

            btnCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}