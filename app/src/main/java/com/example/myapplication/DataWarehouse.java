package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DataWarehouse extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_warehouse);
        tv = (TextView) findViewById(R.id.showAns);

        Bundle bundle = getIntent().getExtras();
        String result = null;
        if (bundle != null) {
            result = bundle.getString("value");
        }
        tv.setText("Your previous result: " + result);
        ;
    }
}