package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        EditText tx1,tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        tx1 = (EditText) findViewById(R.id.username);
        tx2= (EditText) findViewById(R.id.password);

        String uname = tx1.getText().toString();
        String pass = tx2.getText().toString();

        if(uname.equals("harman") && pass.equals("harman")){

            Intent intent = new Intent(MainActivity.this,Welcome.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Error !!!", Toast.LENGTH_LONG).show();
        }

    }
}
