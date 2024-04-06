package com.example.lampstoreapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.lampstoreapp.Helper.ChangeNumberItemsListener;
import com.example.lampstoreapp.Helper.ManagementCart;
import com.example.lampstoreapp.databinding.ViewholderCartBinding;
import com.example.lampstoreapp.domain.PopularDomain;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;
    ViewholderCartBinding binding;
    ChangeNumberItemsListener changeNumberItemsListener ;
    ManagementCart managementCart;

    public CartAdapter(ArrayList<PopularDomain> items, ChangeNumberItemsListener changeNumberItemsListener) {
        this.items = items;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        managementCart=new ManagementCart(context);
        return new Viewholder(binding);
    }

    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.feeEachItem.setText("$" + items.get(position).getPrice());
        binding.totalEachItem.setText("$" + Math.round(items.get(position).getNumberInCart()*items.get(position).getPrice()));
        binding.numberItemTxt.setText(String.valueOf( items.get(position).getNumberInCart()));

        int drawableResourced = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl()
                , "drawable", holder.itemView
                        .getContext().getPackageName());


        Glide.with(holder.itemView.getContext())
                .load(drawableResourced)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(binding.pic);

       binding.plusCartBtn.setOnClickListener(v-> managementCart.plusNumberItem(items, position, ()->{
            notifyDataSetChanged();
            changeNumberItemsListener.change();
           }));
       binding.minusCartItem.setOnClickListener(v->managementCart.minusNumberItem(items,position,()->{
           notifyDataSetChanged();
           changeNumberItemsListener.change();
       }));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderCartBinding binding) {
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









