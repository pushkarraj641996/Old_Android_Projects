package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText note;
    MyAdapter myAdapter;
    String val;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Button bt;
    ArrayList<String> arrayList;
    Time Fragment2 = (Time) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note = (EditText) findViewById(R.id.message);
        val = note.getText().toString();
        arrayList = new ArrayList<String>();
        arrayList.add(val);
        myAdapter = new MyAdapter(arrayList, MainActivity.this);
    }

    public void send(View view){
        TimePicker timePicker = findViewById(R.id.timePick);
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        Toast.makeText(MainActivity.this, hour + ":" +min, Toast.LENGTH_SHORT).show();
    }

    public void time(View view){

        fragmentManager = getSupportFragmentManager();
        Fragment frag  = new Time();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, frag);
        fragmentTransaction.commit();
    }
}
