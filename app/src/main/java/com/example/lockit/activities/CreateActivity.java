package com.example.lockit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lockit.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateActivity extends AppCompatActivity {

    private EditText etFirstname;
    private EditText etLastname;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirm;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        etFirstname = (EditText) findViewById(R.id.etFirstName);
        etLastname = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirmPassword);
        btnCreate = (Button) findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstName = etFirstname.getText().toString();
                final String lastName = etLastname.getText().toString();
                final String email = etEmail.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final String confirm = etConfirm.getText().toString();
                final boolean match = passwordMatch(password, confirm);

                if (!match) {
                    Toast.makeText(CreateActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else {
                    createAccount(firstName, lastName, email, username, password);
                }
            }
        });
    }

    private boolean passwordMatch(String password, String confirm) {
        return password.equals(confirm);
    }

    private void createAccount(String firstName, String lastName, String email, String username, String password) {
        // Log out any current user
        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }

        // Create the ParseUser
        ParseUser user = new ParseUser();

        // Set core properties
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.put("firstname", firstName);
        user.put("lastname", lastName);

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("CreateActivity", "Account creation successful!");
                    final Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.d("CreateActivity", "Account creation failed.");
                    e.printStackTrace();
                }
            }
        });
    }
}