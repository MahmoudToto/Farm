package com.example.farm.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farm.R;
import com.example.farm.pojo.Farm;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FarmViewHolder> {
    List<Farm> farms;
  //  MainViewModel viewModel;
    public RecyclerViewAdapter(List<Farm> farms)
    {
        this.farms = farms;
    //    this.viewModel = viewModel;

    }



    @NonNull
    @Override
    public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_list,
                parent,false);
        FarmViewHolder viewHolder = new FarmViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        Farm f = farms.get(position);
        holder.CustomerName.setText(f.getCustomerName());
        holder.sellerName.setText(f.getSellerName());
    }

    @Override
    public int getItemCount() {
        return farms.size();
    }
//    public void filterlist(List<Farm> farms){
//        this.farms = farms;
//        notifyDataSetChanged();
//    }
    class FarmViewHolder extends RecyclerView.ViewHolder{

        TextView CustomerName,sellerName;
        public FarmViewHolder(@NonNull View itemView) {
            super(itemView);

            CustomerName = itemView.findViewById(R.id.info_name_customer);
            sellerName = itemView.findViewById(R.id.info_name_seller);


        }
    }
}
