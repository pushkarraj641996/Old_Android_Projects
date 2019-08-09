package com.example.asynconous;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText time;
    TextView tx;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (EditText) findViewById(R.id.sleeptime);
        tx = (TextView) findViewById(R.id.info);
        bt = (Button) findViewById(R.id.sleep);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asyncTask as = new asyncTask();
                String val = time.getText().toString();
                as.execute(val);
            }
        });
    }

    public class asyncTask extends AsyncTask<String,String,String> {

        String resp;
        @Override
        protected String doInBackground(String... strings) {
            try{
                int time = Integer.parseInt(strings[0])*1000;
                Thread.sleep(time);
                resp = "Slept for " + strings[0] + " seconds";
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            return resp;
        }
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this,"Progress Bar", "Wait for "+ time.getText().toString() + "seconds");

        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            tx.setText(s);
        }
    }
}
