package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputEditText;
    TextView outputTextView, inputUnitTextView, outputUnitTextView;
    ImageButton swapImageButton;

    double inputNum = 0;
    double outputNum = 0;
    boolean cmTom = true; // cm -> m


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        outputTextView = findViewById(R.id.outputTextView);
        inputUnitTextView = findViewById(R.id.inputUnitTextView);
        outputUnitTextView = findViewById(R.id.outputUnitTextView);
        swapImageButton = findViewById(R.id.swapImageButton);

        inputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {


                if(inputEditText.getText().toString().isEmpty() == true){
                    Toast.makeText(MainActivity.this, "수를입력하세요", Toast.LENGTH_SHORT).show();
                    inputNum = 0;
                }else
                    inputNum = Double.parseDouble(inputEditText.getText().toString());

                if(cmTom==true) // cm->m
                    outputNum = inputNum/100.0;
                else // m -> cm
                    outputNum = inputNum * 100.0;

                outputTextView.setText(String.format("%.2f", outputNum));
            }
        });

        swapImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmTom = !cmTom;
                if(inputEditText.getText().toString().isEmpty() == true){
                    Toast.makeText(MainActivity.this, "수를입력하세요", Toast.LENGTH_SHORT).show();
                    inputNum = 0;
                }else
                    inputNum = Double.parseDouble(inputEditText.getText().toString());

                if(cmTom==true){ // cm->m
                    inputUnitTextView.setText("cm");
                    outputUnitTextView.setText("m");
                    outputNum = inputNum/100;
                } else {
                    inputUnitTextView.setText("m");
                    outputUnitTextView.setText("cm");
                    outputNum = inputNum * 100;
                }

                outputTextView.setText(String.format("%.2f", outputNum));
            }
        });
    }
}