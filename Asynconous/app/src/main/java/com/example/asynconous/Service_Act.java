package com.example.asynconous;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Service_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_);
    }

    public void onstart(View view){
        Intent intent = new Intent(Service_Act.this, MyService.class);
        startService(intent);
    }

    public void onstop(View view){
        Intent intent = new Intent(Service_Act.this, MyService.class);
        stopService(intent);
    }
}
