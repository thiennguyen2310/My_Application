package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    TextView t;
    int num;
    Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Button sum, sub,mul, div, del , equal;
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
    }

    private void assignId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String data = t.getText().toString();

        if (buttonText.equals("DEL")) {
            t.setText("0");
        }
        if (buttonText.equals("=")) {
            t.setText(t.getText());
        }
        else {
            data = data + buttonText;
        }
        t.setText(data);
        String finalResult = getResult(data);

        if(!finalResult.equals("Err")){
            t.setText(finalResult);
        }
    }

    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }
}