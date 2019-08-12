package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText user;
    EditText pass;

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Home(View view){
        user = (EditText)findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);

        username = user.getText().toString();
        password = pass.getText().toString();


        if(username.equals("pushkar") && password.equals("password")){
            Toast.makeText(Login.this, "Logged in !!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);
            user.getText().clear();
            pass.getText().clear();
        }

        else{
            Toast.makeText(Login.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
            user.getText().clear();
            pass.getText().clear();
        }
    }
}
