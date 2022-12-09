package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class IncomeOption extends AppCompatActivity implements View.OnClickListener{

    int var1;
    int var2 = 0;
    String str = "";
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btn_plus, btn_minus, btn_clear, btn_equals;
    ImageButton btn_del;
    TextView string_ans, result;
    String operator = "";
    String before;
    RadioGroup incomeType;
    int answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_option);

        Intent it = getIntent();
        before = it.getStringExtra("total");

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_clear = findViewById(R.id.btn_clear);
        btn_del = findViewById(R.id.btn_del);
        btn_equals = findViewById(R.id.btn_equals);

        string_ans = findViewById(R.id.answer);
        result = findViewById(R.id.result);

        incomeType = findViewById(R.id.expensesType);
    }

    public void send(View v)
    {
        Intent it = new Intent();
        String str;
        it.setClass(IncomeOption.this, MainActivity.class);
        it.putExtra("income", Integer.toString(answer));
        answer += Integer.parseInt(before);
        str = Integer.toString(answer);
        it.putExtra("total", str);
        startActivity(it);
    }

    @Override
    public void onClick(View view)
    {
        //string_ans.setText("btn0");
        if(view.getId() == btn0.getId()) {
            str = str + btn0.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn1.getId()) {
            str = str + btn1.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn2.getId()) {
            str = str + btn2.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn3.getId()) {
            str = str + btn3.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn4.getId()) {
            str = str + btn4.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn5.getId()) {
            str = str + btn5.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn6.getId()) {
            str = str + btn6.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn7.getId()) {
            str = str + btn7.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn8.getId()) {
            str = str + btn8.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn9.getId()) {
            str = str + btn9.getText().toString();
            string_ans.setText("" + str);
        }
        else if(view.getId() == btn_equals.getId()) {
            // 取得 var2
            var2 = Integer.parseInt(str);
            str = "";

            // 計算出答案
            if (operator.equals("plus")){
                answer = var1 + var2;
            }
            else if (operator.equals("minus")){
                answer = var1 - var2;
            }
            else{
                answer = var1;
            }
            string_ans.setText(Integer.toString(answer));

            // 將答案載入上方顯示區
            switch (incomeType.getCheckedRadioButtonId()){
                case R.id.foodUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on Food Selling.");
                    break;
                case R.id.clothesUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on Clothes Selling.");
                    break;
                case R.id.houseUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on House Renting.");
                    break;
                case R.id.transportationUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on Transportation Selling.");
                    break;
                case R.id.teachingUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on Teaching.");
                    break;
                case R.id.performanceUnit:
                    result.setText("You get TWD " + Integer.toString(answer) + " on Performance.");
                    break;
            }
        }
        else if(view.getId() == btn_clear.getId()){
            // 清除計算介面
            str = "";
            string_ans.setText("" + str);
        }
        else if (view.getId() == btn_del.getId()) {
            str = str.substring(0, str.length()-1);
            string_ans.setText("" + str);
        }
        else{
            // 取得 var1 的值
            var1 = Integer.parseInt(str);
            str = "";
            if(view.getId() == btn_plus.getId()){
                operator = "plus";
            }
            else if (view.getId() == btn_minus.getId()) {
                operator = "minus";
            }
            else {
                string_ans.setText("Error!!");
                string_ans.setTextColor(Color.RED);
            }
        }
    }
}