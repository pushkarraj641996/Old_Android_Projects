package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    EditText et;
    EditText et2,et3;
    final static int REQUEST_PHONE_CALL = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logout){
            Toast.makeText(Home.this, "Logged Out !!!", Toast.LENGTH_LONG).show();
        }
        return true;
    }


    public void oncall(View view) {

        et = (EditText) findViewById(R.id.mobile);

        try {

            String str = et.getText().toString();

            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+str));
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(), "App Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void onsearch(View view){
        String s = "http://www.google.com/#q=";

        et2=(EditText)findViewById(R.id.search);
        String query = et2.getText().toString();
        String fquery = s + query;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fquery));
        startActivity(intent);

    }

    public void onsend(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "News");
        startActivity(intent);
    }
}
