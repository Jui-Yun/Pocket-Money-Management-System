package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static boolean RUN_ONCE = true;

    TextView deposit;
    String record_main;
    String record_income;
    String record_expenses;
    String expenses_main;
    String income_main;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        deposit = findViewById(R.id.deposit);

        Intent it = getIntent();
        record_main = it.getStringExtra("total");
        record_income = it.getStringExtra("income");
        record_expenses = it.getStringExtra("expenses");
        record_main = "0";
        spinner.setOnItemSelectedListener(this);

        runOnce();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if(position == 0){
            deposit.setText(record_main);
        }
        else if(position == 1){
            deposit.setText(record_income);
        }
        else if(position == 2){
            deposit.setText(record_expenses);
        }
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // 此事件方法不會用到，但仍需定義一個沒有內容的方法
    }

    private void runOnce() {
        if (RUN_ONCE) {
            RUN_ONCE = false;

            deposit.setText("0");
            record_main = "0";
        }
        else {
            Intent it = getIntent();
            record_main = it.getStringExtra("total");
            expenses_main = it.getStringExtra("expenses");
            income_main = it.getStringExtra("income");
            deposit.setText(record_main);
        }
    }

    public void gotoIncomeOption(View v)
    {
        Intent it = new Intent();
        it.setClass(MainActivity.this, IncomeOption.class);
        it.putExtra("total", record_main);
        startActivity(it);
    }
    public void gotoExpensesOption(View v)
    {
        Intent it = new Intent();
        it.setClass(MainActivity.this, ExpensesOption.class);
        it.putExtra("total", record_main);
        startActivity(it);
    }
}