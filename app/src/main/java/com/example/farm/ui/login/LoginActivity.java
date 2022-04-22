package com.example.farm.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.farm.ui.main.MainActivity;
import com.example.farm.R;
import com.example.farm.ui.register.RegisterActivity;
import com.example.farm.pojo.Admin;

public class LoginActivity extends AppCompatActivity {
    public static String ADMIN_KEY = "admin_key";
    private TextView register;
    private Button login;
    private EditText etPassword, etEmail;
    private String getemail, getpassword;
    private LoginViewModel loginViewModel;
    private Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        loginViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(LoginViewModel.class);

        register = findViewById(R.id.tv_register);
        etEmail = findViewById(R.id.log_email);
        etPassword = findViewById(R.id.log_password);
        login = findViewById(R.id.btn_log_in);


        login.setOnClickListener(view -> {
            getemail = etEmail.getText().toString();
            getpassword = etPassword.getText().toString();
            if(!isValide()) return;
            admin = new Admin(getemail, getpassword);
            loginViewModel.login(admin).observe(this, new Observer<Admin>() {
                @Override
                public void onChanged(Admin result) {
                    if(result != null){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        });

    }


    private boolean isValide() {

        if(getemail.isEmpty() || getemail.replaceAll("\\s", "").equals(""))
            return false;
        else if(getpassword.isEmpty() || getpassword.replaceAll("\\s", "").equals(""))
            return false;

        return true;

    }
}
