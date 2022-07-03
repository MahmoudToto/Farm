package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.CatViewHolder> {

    ArrayList<Cat>cats;

    public RecyclerViewAdapter(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()) .inflate(R.layout.cat_custom_item ,null , false);
        CatViewHolder viewHolder =  new CatViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat c =  cats.get(position);
        holder.iv_image.setImageResource(c.getImg());
        holder.tv_name.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    // holder class
    class CatViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        ImageView iv_image;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name =  itemView.findViewById(R.id.cat_custom_tv);
            iv_image = itemView.findViewById(R.id.cat_custom_iv);

        }
    }
}
