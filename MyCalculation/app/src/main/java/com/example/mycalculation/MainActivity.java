package com.example.mycalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    EditText et1,et2, et3;
    String num1,num2;

    Button bt1,bt2,bt3,bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.num1);
        et2 = (EditText) findViewById(R.id.num2);
        et3 = (EditText) findViewById(R.id.Result);
        bt1 = (Button)findViewById(R.id.add);
        bt2 = (Button)findViewById(R.id.sub);
        bt3 = (Button)findViewById(R.id.multiply);
        bt4 = (Button)findViewById(R.id.divide);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                int a = (int) Integer.parseInt(num1);
                int b = (int) Integer.parseInt(num2);

                et3.setText(""+add(a,b));
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                int a = (int) Integer.parseInt(String.valueOf(et1));
                int b = (int) Integer.parseInt(String.valueOf(et2));

                et3.setText(""+sub(a,b));
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                int a = (int) Integer.parseInt(String.valueOf(et1));
                int b = (int) Integer.parseInt(String.valueOf(et2));

                et3.setText(""+multiply(a,b));
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = et1.getText().toString();
                num2 = et2.getText().toString();
                int a = (int) Integer.parseInt(String.valueOf(et1));
                int b = (int) Integer.parseInt(String.valueOf(et2));

                et3.setText(""+divide(a,b));
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int add (int a, int b);

    public native int sub (int a, int b);

    public native int multiply (int a, int b);

    public native int divide (int a, int b);
}
