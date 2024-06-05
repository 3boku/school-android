package com.example.intenttest;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        findViewById(R.id.dialButton).setOnClickListener(this);
        findViewById(R.id.mapButton).setOnClickListener(this);
        findViewById(R.id.smsButton).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActibity.class);

                launcher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {

                    if(o.getResultCode()==RESULT_OK) {
                        String str = o.getData().getStringExtra("key");
                        resultTextView.setText(str);
                    }
                }
            }
    );

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialButton:
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                startActivity(dialIntent);

                break;

            case R.id.mapButton:
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=서울"));
                startActivity(mapIntent);

                break;

            case R.id.smsButton:
                Intent smsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:01021220739"));
                smsIntent.putExtra("sms_body", "안녕하세요");
                startActivity(smsIntent);

                break;
        }
    }
}