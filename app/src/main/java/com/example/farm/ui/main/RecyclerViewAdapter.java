package com.example.farm.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farm.R;
import com.example.farm.pojo.Farm;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FarmViewHolder> {
    List<Farm> farms;
    MainViewModel viewModel;
    public RecyclerViewAdapter(List<Farm> farms, MainViewModel viewModel)
    {
        this.farms = farms;
        this.viewModel = viewModel;

    }



    @NonNull
    @Override
    public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_list,
                null,false);
        FarmViewHolder viewHolder = new FarmViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        Farm f = farms.get(position);
        holder.name.setText(f.getCustomerName());
        holder.area.setText(f.getArea());
    }

    @Override
    public int getItemCount() {
        return farms.size();
    }
    public void filterlist(List<Farm> farms){
        this.farms = farms;
        notifyDataSetChanged();
    }
    class FarmViewHolder extends RecyclerView.ViewHolder{
      //  TextView name, seller, area, plante, number;
     //   EditText transactions;
        TextView name,area;
        public FarmViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.details_tv_name);
          //  seller = itemView.findViewById(R.id.details_tv_seller);
          //  area = itemView.findViewById(R.id.details_tv_area);
            area = itemView.findViewById(R.id.details_tv_seller);
//            plante = itemView.findViewById(R.id.details_tv_plante);
//            number = itemView.findViewById(R.id.details_tv_number);
//            transactions = itemView.findViewById(R.id.details_tv_transactions);


        }
    }
}
