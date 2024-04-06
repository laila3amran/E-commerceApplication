package com.example.lampstoreapp.Activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.lampstoreapp.Helper.ManagementCart;
import com.example.lampstoreapp.R;
import com.example.lampstoreapp.databinding.ActivityDetailsBinding;
import com.example.lampstoreapp.domain.PopularDomain;

public class DetailsActivity extends AppCompatActivity {
  private ActivityDetailsBinding  binding;
  private PopularDomain object;
  private final int numberOrder=1;
  private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundles();
        managementCart = new ManagementCart(this);
        statusBarColor();


    }
    private void statusBarColor() {
        Window window = DetailsActivity.this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(DetailsActivity.this, R.color.white));
    }

    private void getBundles() {
        object= (PopularDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.itemPic);

        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.descriptionTxt.setText(object.getDescription());
        binding.reviewTxt.setText(object.getReview()+"");
        binding.ratingTxt.setText(object.getScore()+"");
        binding.addToCardBtn.setOnClickListener(v->{
                                object.setNumberInCart(numberOrder);
                                managementCart.insertFood(object);
                                                });
                binding.backBtn.setOnClickListener(v->finish());
    }
}