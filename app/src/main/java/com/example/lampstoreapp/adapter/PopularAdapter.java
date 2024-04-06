package com.example.lampstoreapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.lampstoreapp.Activity.DetailsActivity;
import com.example.lampstoreapp.databinding.ViewholderPupListBinding;
import com.example.lampstoreapp.domain.PopularDomain;

import java.util.ArrayList;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderPupListBinding binding;


    public PopularAdapter(ArrayList<PopularDomain> items) {

        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderPupListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.feeTxt.setText("$" + items.get(position).getPrice());
        binding.scoreText.setText("" + items.get(position).getScore());
        binding.reviwTxt.setText("" + items.get(position).getReview());

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                , "drawable", holder.itemView
                        .getContext().getPackageName());


        Glide.with(holder.itemView.getContext())
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("object", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPupListBinding binding) {
            super(binding.getRoot());
        }


    }
}
/*
    @Override
    public void onBindViewHolder(Viewholder holder, @SuppressLint("RecyclerView") int position) {
     binding.titleTxt.setText(items.get(position).getTitle());
     binding.feeTxt.setText("$"+items.get(position).getPrice());
     binding.scoreText.setText(""+items.get(position).getScore());

     int drawableResourced=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
             ,"drawable",holder.itemView
                     .getContext().getPackageName());


     Glide.with(holder.itemView.getContext())
             .load(drawableResourced)
             .transform(new GranularRoundedCorners(30,30,0,0))
             .into(binding.pic);



     holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
               intent.putExtra("object",items.get(position));
               context.startActivity(intent);
            }
        });
    }
*/









