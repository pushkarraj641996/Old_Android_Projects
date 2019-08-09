package com.example.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String list[] = new String[] {"Pushkar", "Aarsh", "Ujjwal"};

    // create adapter

    ArrayAdapter adapter;
    //Recycler View

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(MainActivity.this, parent.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                switch(i){
                    case 0:
                        listview.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        listview.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        });

    }


}
