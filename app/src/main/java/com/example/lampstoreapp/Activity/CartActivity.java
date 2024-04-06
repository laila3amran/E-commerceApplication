package com.example.lampstoreapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lampstoreapp.Helper.ManagementCart;
import com.example.lampstoreapp.R;
import com.example.lampstoreapp.adapter.CartAdapter;
import com.example.lampstoreapp.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private ManagementCart managementCart;
    private ActivityCartBinding binding;
    double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managementCart=new ManagementCart(this);
        setVariable();
        initList();
        calculatorCart();
        statusBarColor();

    }
    private void statusBarColor() {
        Window window = CartActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(CartActivity.this, R.color.purple_dark));
    }




    private void initList() {
        if (managementCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scroll.setVisibility(View.GONE);
        }else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scroll.setVisibility(View.VISIBLE);
        }
        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.cartView.setAdapter(new CartAdapter(managementCart.getListCart(),()-> calculatorCart()));
    }
    public void calculatorCart(){
        double percentTax = 0.02;
        double delivery=10;
        tax=Math.round(managementCart.getTotalFee()*percentTax*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee()*100)/100;
        binding.totalFeeTxt.setText("$"+itemTotal);
        binding.taxTxt.setText("$"+tax);
        binding.deliveryTxt.setText("$"+delivery);
        binding.totalTxt.setText("$"+total);


    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v->finish());
    }
}