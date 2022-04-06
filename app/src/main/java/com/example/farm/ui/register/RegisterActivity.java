package com.example.farm.ui.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.example.farm.ui.main.MainActivity;
import com.example.farm.R;
import com.example.farm.pojo.Admin;

public class RegisterActivity extends AppCompatActivity {
    private EditText register_number, register_password, register_email, register_name;
    private Button btn_create_account;
    private String name, email, password, number;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(RegisterViewModel.class);

        btn_create_account = findViewById(R.id.btn_create_account);
        register_name = findViewById(R.id.tv_register_name);
        register_email = findViewById(R.id.tv_register_email);
        register_password = findViewById(R.id.tv_register_password);
        register_number = findViewById(R.id.tv_register_number);


        btn_create_account.setOnClickListener(view -> {
            name = register_name.getText().toString();
            email = register_email.getText().toString();
            password = register_password.getText().toString();
            number = register_number.getText().toString();

            if(!isValide()) return;

            Admin admin = new Admin(name, email, number, password);

            registerViewModel.createEmailAdmin(admin).observe(this, result -> {
                if(result != null){
                    Intent intent = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        });


    }

    private boolean isValide() {

        if(name.isEmpty() || name.replaceAll("\\s", "").equals(""))
            return false;
        else if(email.isEmpty() || email.replaceAll("\\s", "").equals(""))
            return false;

        else if(password.replaceAll("\\s", "").length() < 6 || name.replaceAll("\\s", "").equals(""))
            return false;
        else if(number.isEmpty() || number.replaceAll("\\s", "").equals(""))
            return false;

        return true;

    }

}
