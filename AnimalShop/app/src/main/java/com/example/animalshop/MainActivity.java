package com.example.animalshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.animalshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    int selected_proudct = 1500; // 선택한 제품 한개의 가격
    int selected_count; // 선택한 수량
    int val_price; // 제품 총 가격
    int val_delivery; // 배송비(제품 총 가격이 10000원 이상이면 배송비 무료, 미만이면 2500)
    int val_pay; // 최종결제 금액

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        sumTotal();

        binding.radio1.setOnClickListener(this);
        binding.radio2.setOnClickListener(this);
        binding.radio3.setOnClickListener(this);
        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String str = binding.editCount.getText().toString();
        int count = Integer.parseInt(str);

        if(view.getId() == R.id.radio1){
            binding.imgProductMain.setImageResource(R.drawable.product1);
            selected_proudct = 1500;
            sumTotal();
        } else if (view.getId() == R.id.radio2) {
            binding.imgProductMain.setImageResource(R.drawable.product2);
            selected_proudct = 2000;
            sumTotal();
        } else if (view.getId() == R.id.radio3) {
            binding.imgProductMain.setImageResource(R.drawable.product3);
            selected_proudct = 3000;
            sumTotal();
        } else if (view.getId() == R.id.btn_plus){
            binding.editCount.setText(count+1+"");
            sumTotal();
        } else if (view.getId() == R.id.btn_minus) {
            if(count == 1) {
                Toast.makeText(this, "최소 수량은 1개에요.", Toast.LENGTH_SHORT).show();
            } else {
                binding.editCount.setText(count-1+"");
                sumTotal();
            }
        } else if (view.getId() == R.id.btn_pay) {
            if(binding.chkAgree.isChecked()==true)
                Toast.makeText(this, val_pay+"원 결제 하겠습니다.", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "결제 동의 버튼을 체크해주세요", Toast.LENGTH_SHORT).show();
        }
    }

    private void sumTotal() {
        selected_count = Integer.parseInt(binding.editCount.getText().toString());

        val_price = selected_proudct * selected_count; // 제품 총 가격 = 선택한 한개 가격 * 수량

        if (val_price >= 10000) {
            val_delivery = 0;
        } else {
            val_delivery = 2500;
        }

        val_pay = val_price + val_delivery;

        binding.txtPrice.setText(val_price+"원");
        binding.txtDelivery.setText(val_delivery+"원");
        binding.txtPrice.setText(val_pay+"원");
    }
}