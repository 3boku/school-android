package com.example.numbercounter;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button reset, plus;
    int count=0;
    TextView number; // EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetButton);
        plus = findViewById(R.id.plusButton);
        number = findViewById(R.id.numberTextView);

        reset.setOnClickListener(this);
        plus.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.resetButton:
                count = 0;
                number.setText(count+"");
                Log.i("onCLick", "리셋된 숫자는 " + count);
                break;
            case R.id.plusButton:
                count++;
                number.setText(count+"");
                Log.i("onCLick", "플러스된 숫자는 " + count);
                break;
        }
    }
}