package com.example.custom;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Home_Screen extends AppCompatActivity {

    EditText ph, query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
    }

    public void onCall(View view) {
        ph = (EditText) findViewById(R.id.mobile);
        String str = ph.getText().toString();

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }

    public void onSearch(View view){
        String URL = "http://www.google.com/";
        query = (EditText)findViewById(R.id.search);

        String search = query.getText().toString();

        String final_query = URL + search;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(final_query));
        startActivity(intent);
    }

    public void onSend(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String message = "Hello World !!!";
        intent.putExtra(intent.EXTRA_TEXT, message);
        startActivity(intent);
    }
}
