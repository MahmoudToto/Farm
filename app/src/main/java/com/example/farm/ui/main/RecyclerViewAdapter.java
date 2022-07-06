package com.example.farm.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farm.R;
import com.example.farm.pojo.Farm;
import com.example.farm.ui.data.DataViewModel;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FarmViewHolder>{
    List<Farm> farms;
    DataViewModel dataViewModel;
    private final RecyclerInterface recyclerInterface;
  //  MainViewModel viewModel;
    public RecyclerViewAdapter(List<Farm> farms,RecyclerInterface recyclerInterface)
    {
        this.farms = farms;
        this.recyclerInterface = recyclerInterface;
    //    this.viewModel = viewModel;

    }



    @NonNull
    @Override public FarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_list,
                parent,false);
        FarmViewHolder viewHolder = new FarmViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmViewHolder holder, int position) {
        Farm f = farms.get(position);
        int post = holder.getAdapterPosition();
        holder.CustomerName.setText(f.getCustomerName());
        holder.sellerName.setText(f.getSellerName());
        holder.delte.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            farms.remove(post);
            notifyItemRemoved(post);
//            DialogFragment fragment = DialogFragment.newInstance;
//            dataViewModel.DeletFarmer(farms.get(post));
        }
    });
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

        ImageView delte ;
        TextView CustomerName,sellerName;
        public FarmViewHolder(@NonNull View itemView) {
            super(itemView);

            CustomerName = itemView.findViewById(R.id.info_name_customer);
            delte= itemView.findViewById(R.id.delte_icon);
            sellerName = itemView.findViewById(R.id.info_name_seller);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
