package com.example.custom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        et = (EditText) findViewById(R.id.uname);
        et2 = (EditText) findViewById(R.id.password);

        String user = et.getText().toString();
        String pass = et2.getText().toString();

        if (user.equals("Harman") && pass.equals("password")) {
            Intent intent = new Intent(MainActivity.this, Home_Screen.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Invalid User ID or Password", Toast.LENGTH_LONG).show();
        }
    }

    public void register(View view){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}
