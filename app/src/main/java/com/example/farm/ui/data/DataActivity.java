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
import androidx.lifecycle.ViewModelProvider;

import com.example.farm.R;
import com.example.farm.pojo.Admin;
import com.example.farm.pojo.Farm;
import com.example.farm.ui.login.LoginActivity;

public class DataActivity extends AppCompatActivity {
    private Button dataSave;
    private EditText name,area,plant,sellerName, number;
    private DataViewModel viewModel;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        viewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(DataViewModel.class);
        progressBar = findViewById(R.id.data_pb);
        dataSave = findViewById(R.id.btn_save_data);
        name = findViewById(R.id.tv_client_name);
        area = findViewById(R.id.tv_client_area);
        plant = findViewById(R.id.tv_client_plant);
        sellerName = findViewById(R.id.tv_seller_name);
        number = findViewById(R.id.tv_client_number);
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
            viewModel.registerFarm(farm).observe(DataActivity.this, result -> {
                progressBar.setVisibility(View.GONE);
                if(result!=null){
                    Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                    finish();
                }
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            });

        });
    }
}