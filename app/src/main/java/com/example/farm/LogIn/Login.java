package com.example.farm.LogIn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farm.MainActivity;
import com.example.farm.R;
import com.example.farm.Register.Register;
import com.example.farm.ViewModelFactory;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    TextView register;
    Button login;
    EditText register_password, register_email;
    String getemail, getpassword;
    LoginViewModel mvvm;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        register = findViewById(R.id.tv_register);
        register_email = findViewById(R.id.log_user_name);
        register_password = findViewById(R.id.log_password);
        fauth = FirebaseAuth.getInstance();
        login = findViewById(R.id.btn_log_in);

        ViewModelFactory factory = new ViewModelFactory(this);
        mvvm = ViewModelProviders.of(this, factory).get(LoginViewModel.class);

        login.setOnClickListener(view -> {
            getemail = register_email.getText().toString().trim();
            getpassword = register_password.getText().toString().trim();
            if(!check(getemail, getpassword)) return;

            mvvm.LogIn(getemail, getpassword);
        });

        register.setOnClickListener(view -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });

    }

    private boolean check(String getemail, String getpassword) {
        if(getemail.isEmpty()) return false;
        if(getpassword.length() < 6) return false;
        return true;
    }
}