package com.example.imagetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    int imgs[] = {R.drawable.flower1, R.drawable.flower2, R.drawable.flower3};
    int imgno = 0; //인덱스 번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgno = (imgno+1) % 3;
                img.setImageResource(imgs[imgno]);
            }
        });
    }
}