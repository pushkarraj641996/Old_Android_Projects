package com.example.mynote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText note;
    MyAdapter myAdapter;
    TextView text;
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

    public void invokeAlarm(){

        int h,m;

        Toast.makeText(MainActivity.this,"Alarm Set for: " +calendar.get(Calendar.HOUR_OF_DAY) +":" + calendar.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
        h = calendar.get(Calendar.HOUR_OF_DAY);
        m = calendar.get(Calendar.MINUTE);

        if(h > 12){
            text.setText((h-12) + ":" + m + " pm");
        }
        else{
            text.setText(h + ":" + m + " am");
        }
        Intent intent = new Intent(MainActivity.this, Wakeup.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent,0);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
    }

    public void time(View view) {

        text = (TextView) findViewById(R.id.textView4);
        calendar = Calendar.getInstance();
        int currenthour = calendar.get(calendar.HOUR_OF_DAY);
        int currentmin = calendar.get(calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                calendar.set(Calendar.HOUR_OF_DAY,hour);
                calendar.set(Calendar.MINUTE,min);
                calendar.set(Calendar.SECOND,0);
                //Toast.makeText(MainActivity.this, set_hour+":"+set_min, Toast.LENGTH_SHORT).show();
                invokeAlarm();
            }
        }, currenthour, currentmin, false);

        timePickerDialog.show();
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
            onBackPressed();
            Toast.makeText(MainActivity.this, "Logged out Successfully !!!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
