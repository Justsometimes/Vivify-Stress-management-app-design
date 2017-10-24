package com.example.user.vivifystressmanagementappdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    //For implementing full server support, you could continue this tutorial from its linked point
    // https://www.youtube.com/watch?v=JQXfIidfFMo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        final TextView registerLink = (TextView) findViewById(R.id.tvRegisterHere);
        //The function for the button is practically empty and only continues the prototype to the
        //main menu
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent loggedInContinue = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(loggedInContinue);
            }
        });
        //Makes the little 'Register here'  text field act like a button and take the user to the
        //register activity.
        registerLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}
