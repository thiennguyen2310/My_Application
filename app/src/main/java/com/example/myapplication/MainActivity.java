package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView t;
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button sum, sub,mul, div, del , equal, result;
    String math = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.txtView);
        assignId(num0,R.id.num0);
        assignId(num1,R.id.num1);
        assignId(num2,R.id.num2);
        assignId(num3,R.id.num3);
        assignId(num4,R.id.num4);
        assignId(num5,R.id.num5);
        assignId(num6,R.id.num6);
        assignId(num7,R.id.num7);
        assignId(num8,R.id.num8);
        assignId(num9,R.id.num9);
        assignId(sum,R.id.sum);
        assignId(sub,R.id.sub);
        assignId(mul,R.id.mul);
        assignId(div,R.id.div);
        assignId(del,R.id.del);
        assignId(equal,R.id.equal);
        assignId(result, R.id.showAns);
    }

    private void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("DEL")) {
            math = "";
            t.setText(math);
        }  else if (buttonText.equals("=")) {
            if (math.split("\\+").length==2) {
                String number[] = math.split("\\+");
                int answer =  Integer.parseInt(number[0]) + Integer.parseInt(number[1]);
                String finalResult = Integer.toString(answer);
                t.setText(finalResult);
                math = finalResult;
            } else if (math.split("-").length==2) {
                String number[] = math.split("-");
                int answer =  Integer.parseInt(number[0]) - Integer.parseInt(number[1]);
                String finalResult = Integer.toString(answer);
                t.setText(finalResult);
                math = finalResult;
            } else if (math.split("\\*").length==2) {
                String number[] = math.split("\\*");
                int answer =  Integer.parseInt(number[0]) * Integer.parseInt(number[1]);
                String finalResult = Integer.toString(answer);
                t.setText(finalResult);
                math = finalResult;
            } else if (math.split("/").length==2) {
                String number[] = math.split("/");
                int answer =  Integer.parseInt(number[0]) / Integer.parseInt(number[1]);
                String finalResult = Integer.toString(answer);
                t.setText(finalResult);
                math = finalResult;
            }
        } else if (buttonText.equals("Result")) {
            Intent i = new Intent(MainActivity.this, DataWarehouse.class);
            i.putExtra("value", math);
            startActivity(i);
        } else {
            math += buttonText;
            t.setText(math);
        }
    }
}