package com.example.shape;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shape.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActivityResultLauncher<Intent> launcher;

    int[] selectResult = new int[6];
    ImageView[] resultImage = new ImageView[2];
    int[] drawblId = {
            R.drawable.shape01, R.drawable.shape02, R.drawable.shape03,
            R.drawable.shape04, R.drawable.shape05, R.drawable.shape06
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        binding.startImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                if(binding.radioButton1.isChecked()){
                    intent.putExtra("shape", 0);
                    launcher.launch(intent);
                }
                else if(binding.radioButton2.isChecked()){
                    intent.putExtra("shape", 1);
                    launcher.launch(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "찾고 싶은 모양을 클릭하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        resultImage[0] = binding.imageResult01;
        resultImage[1] = binding.imageResult02;

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        selectResult = o.getData().getIntArrayExtra("result");
                        int num = 0;
                        for (int i = 0; i < selectResult.length; i++) {
                            if(selectResult[i]==1){
                                resultImage[num].setVisibility(View.VISIBLE);
                                resultImage[num].setImageResource(drawblId[i]);
                                num++;
                            }
                        }

                    }
                });
    }
}