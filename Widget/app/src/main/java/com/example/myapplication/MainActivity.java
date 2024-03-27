package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_prev, btn_next, btn_exit; //선언

    EditText edit_id, edit_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_info);

        btn_prev = findViewById(R.id.btn_prev);
        btn_next = findViewById(R.id.btn_next);
        btn_exit = findViewById(R.id.btn_exit); //연결

        edit_id = findViewById(R.id.edit_id);
        edit_pwd = findViewById(R.id.edit_pwd);

        btn_prev.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        btn_exit.setOnClickListener(this); // 리스너등록

    }

    @Override
    public void onClick(View view) { // 이벤트처리
        switch (view.getId()){
            case R.id.btn_prev:
                Toast.makeText(this, "이전 버튼 클릭.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_next:
                String str_id = edit_id.getText().toString();
                String str_pwd = edit_pwd.getText().toString();

                if (str_id.length()<1 || str_pwd.length()<1)
                    Toast.makeText(this, "아아디와 비번을 확인하세요.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "아아디는 "+str_id+"이고, 비번은 "+str_pwd+"입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_exit:
                Toast.makeText(this, "종료 버튼 클릭.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}