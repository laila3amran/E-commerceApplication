package com.example.lampstoreapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.lampstoreapp.R;
import com.example.lampstoreapp.adapter.PopularAdapter;
import com.example.lampstoreapp.databinding.ActivityMainBinding;
import com.example.lampstoreapp.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        statusBarColor();
        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation() {
        binding.cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void statusBarColor() {
        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.purple_dark));
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-Shirt black","item_1",15,4,500,"Black cotton t-shirt made from a crisp," +
                " medium-weight 100% cotton and designed for a tailored,\n" +
                " yet comfortable fit. The classic neck rib includes a \n"+
                "touch of lycra to retain its shape over time.Branded with\n" +
                "  the circular Eleven New York embroidery on the chest and \n" +
                "the trademark 11 on the hem.\n"));
        items.add(new PopularDomain("Smart Watch","item_2",15,4,500,"Black cotton t-shirt made from a crisp," +
                " medium-weight 100% cotton and designed for a tailored,\n" +
                " yet comfortable fit. The classic neck rib includes a \n"+
                "touch of lycra to retain its shape over time.Branded with\n" +
                "  the circular Eleven New York embroidery on the chest and \n" +
                "the trademark 11 on the hem.\n"));
        items.add(new PopularDomain("Phone","item_3",15,4,500,"Black cotton t-shirt made from a crisp," +
                " medium-weight 100% cotton and designed for a tailored,\n" +
                " yet comfortable fit. The classic neck rib includes a \n"+
                "touch of lycra to retain its shape over time.Branded with\n" +
                "  the circular Eleven New York embroidery on the chest and \n" +
                "the trademark 11 on the hem.\n"));

        items.add(new PopularDomain("Lamp","item_4",20,4.9,250,"Black cotton t-shirt made from a crisp," +
                " medium-weight 100% cotton and designed for a tailored,\n" +
                " yet comfortable fit. The classic neck rib includes a \n"+
                "touch of lycra to retain its shape over time.Branded with\n" +
                "  the circular Eleven New York embroidery on the chest and \n" +
                "the trademark 11 on the hem.\n"));





        binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}