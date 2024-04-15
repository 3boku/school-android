package com.example.bmi_caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button resultButton;
    EditText heightEditText;
    EditText weightEditText;
    TextView resultText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        resultText = findViewById(R.id.resultText);
        resultButton = findViewById(R.id.resultButton);

        resultButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String str_height = heightEditText.getText().toString();
        String str_weight = weightEditText.getText().toString();

        if(str_weight.isEmpty() || str_height.isEmpty()){
            Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        int height = Integer.parseInt(str_height);
        int weight = Integer.parseInt(str_weight);

        double bmi = weight / Math.pow(height/100, 2.0);
        resultText.setVisibility(View.VISIBLE);
        if(bmi >= 35){
            resultText.setText("고도비만");
        }
        else if(bmi >= 30 && bmi <= 34.9){
            resultText.setText("중정도비만");
        }
        else if(bmi >= 25 && bmi <= 29.9){
            resultText.setText("경도비만");
        }
        else if(bmi >= 23 && bmi <= 24.4){
            resultText.setText("과체중");
        }
        else if(bmi >= 18.5 && bmi <= 22.9){
            resultText.setText("정상체중");
        }
        else if(bmi < 18.5) {
            resultText.setText("저체중");
        }
    }
}
