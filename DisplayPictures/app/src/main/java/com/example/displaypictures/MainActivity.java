package com.example.displaypictures;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.displaypictures.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder>{


        private String mdataset[];


        public class MyviewHolder extends RecyclerView.ViewHolder{
            public
            TextView textView;
            MyviewHolder(TextView v){
                super(v);
                textView = v;
            }
        }

        public MyAdapter(String[] dataset){
            mdataset = dataset;
        }

        @NonNull
        @Override
        public MyAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            MyviewHolder vh = new MyviewHolder(tv);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
            holder.textView.setText(mdataset[position]);
        }

        @Override
        public int getItemCount() {
            return mdataset.length;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String list[] = new String[] {"ABC", "PQR","JKL"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
