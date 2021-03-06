package com.example.farm.ui.data;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.farm.R;
import com.example.farm.pojo.Admin;
import com.example.farm.pojo.Farm;
import com.example.farm.ui.login.LoginActivity;
import com.google.firebase.firestore.FirebaseFirestore;

public class DataActivity extends AppCompatActivity {
    private Button dataSave;
    private EditText name,area,plant,sellerName, number;
    private DataViewModel viewModel;
    private ProgressBar progressBar;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        viewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(DataViewModel.class);
        progressBar = findViewById(R.id.data_pb);
        dataSave = findViewById(R.id.data_btn_save_data);
        name = findViewById(R.id.data_customer_name);
        area = findViewById(R.id.data_customer_area);
        plant = findViewById(R.id.data_customer_plant);
        sellerName = findViewById(R.id.data_seller_name);
        number = findViewById(R.id.data_customer_number);
        init();
    }

    public void init(){
        dataSave.setOnClickListener(view -> {
            Farm farm = new Farm(
                    name.getText().toString(),
                    area.getText().toString(),
                    plant.getText().toString(),
                    sellerName.getText().toString(),
                    number.getText().toString());
            progressBar.setVisibility(View.VISIBLE);
            viewModel.insertFarmer(farm).observe(this, new Observer<Long>() {
                @Override
                public void onChanged(Long id) {
                    progressBar.setVisibility(View.GONE);
                    finish();
                    //viewModel.registerFarm(farm).observe(DataActivity.this, result -> {
    //                progressBar.setVisibility(View.GONE);
    //                if(result!=null){
    //                    Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
    //                    finish();
    //                }
    //                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    //            });

                }
            });


        });
    }

}