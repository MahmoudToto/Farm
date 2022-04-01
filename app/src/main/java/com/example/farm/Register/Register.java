package com.example.farm.Register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.farm.R;
import com.example.farm.ViewModelFactory;
import com.example.farm.pojo.Admin;

public class Register extends AppCompatActivity {
    EditText register_number, register_password, register_email, register_name;
    Button btn_create_account;
    String name, email, password, number;
    RegisterViewModel mvvm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn_create_account = findViewById(R.id.btn_create_account);
        register_name = findViewById(R.id.tv_register_name);
        register_email = findViewById(R.id.tv_register_email);
        register_password = findViewById(R.id.tv_register_password);
        register_number = findViewById(R.id.tv_register_number);


        ViewModelFactory factory = new ViewModelFactory(this);
        mvvm = ViewModelProviders.of(this, factory).get(RegisterViewModel.class);


        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = register_name.getText().toString();
                email = register_email.getText().toString();
                password = register_password.getText().toString();
                number = register_number.getText().toString();
                Admin user_info = new Admin(name, email, number, password);
                mvvm.CreateEmailandSavindData(user_info, email, password);
            }
        });

    }

}