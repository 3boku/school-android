package com.example.suhang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultText;
    EditText heightText, weightText;
    Button resultButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        heightText = findViewById(R.id.heightEditText);
        weightText = findViewById(R.id.weightEditText);
        resultButton = findViewById(R.id.resultButton);

        resultButton.setOnClickListener(this);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public void onClick(View v) {
        if(heightText.getText().toString().isEmpty() || weightText.getText().toString().isEmpty()){
            Toast.makeText(this, "빈칸이 있습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        int height = Integer.parseInt(heightText.getText().toString());
        int weight = Integer.parseInt(weightText.getText().toString());

        double bmi = weight / Math.pow(height/100.0, 2.0);
        resultText.setVisibility(View.VISIBLE);

        if (bmi >= 35){
            resultText.setText("고도비만");
        }
        else if (bmi >= 30){
            resultText.setText("중정도비만");
        }
        else if (bmi >= 25){
            resultText.setText("경도비만");
        }
        else if (bmi >= 23){
            resultText.setText("과체중");
        }
        else if (bmi >= 18.5){
            resultText.setText("정상체중");
        }
        else if (bmi <= 18.4){
            resultText.setText("저체중");
        }
    }
}