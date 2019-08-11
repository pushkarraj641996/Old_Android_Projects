package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText note;
    MyAdapter myAdapter;
    String val;
    Calendar calendar;
    ImageButton bt;
    ArrayList<String> arrayList;
    ListView listView;
    AlarmManager alarmManager;
    int set_hour;
    int set_min;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<String>();
        note = (EditText) findViewById(R.id.message);
        bt = (ImageButton) findViewById(R.id.alarm);
        listView = (ListView) findViewById(R.id.listView);
    }
    public void add(View view){
        val = note.getText().toString();
        arrayList.add(val);
        myAdapter = new MyAdapter(arrayList, MainActivity.this);
        listView.setAdapter(myAdapter);
        note.getText().clear();

    }

    public void time(View view){


        Intent intent = new Intent(MainActivity.this, Alarm.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(getApplicationContext(),0,PendingIntent,0);
        calendar =Calendar.getInstance();
        int currenthour = calendar.get(calendar.HOUR_OF_DAY);
        int currentmin = calendar.get(calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                Toast.makeText(MainActivity.this, hour + ":" + min, Toast.LENGTH_SHORT).show();
                set_hour = hour;
                set_min = min;
            }
            }, currenthour, currentmin, false);

                timePickerDialog.show();

        calendar.set(Calendar.HOUR_OF_DAY,set_hour);
        calendar.set(Calendar.MINUTE,set_min);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY,alarmIntent);
    }


}
