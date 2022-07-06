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
    private EditText register_number,confPassword, register_password, register_email, register_name;
    private Button create_account;
    private String name, email, password,confirmPassword, number;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        registerViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(RegisterViewModel.class);

        create_account = findViewById(R.id.register_btn_signup);
        confPassword = findViewById(R.id.register_tv_confpassword);
        register_email = findViewById(R.id.register_tv_email);
        register_password = findViewById(R.id.register_tv_password);
//        register_number = findViewById(R.id.tv_register_number);


        create_account.setOnClickListener(view -> {
            name = register_name.getText().toString();
            email = register_email.getText().toString();
            password = register_password.getText().toString();
            confirmPassword = confPassword.getText().toString();
//            number = register_number.getText().toString();

            if(!isValide()) return;
            Admin admin = new Admin(name, email,confirmPassword, password);

            registerViewModel.createEmailAdmin(admin).observe(this, result -> {
                if(result != null){
                    Intent intent = new Intent(RegisterActivity.this,
                            MainActivity.class);
                    startActivity(intent);
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
//        else if(number.isEmpty() || number.replaceAll("\\s", "").equals(""))
//            return false;

        return true;

    }

}
