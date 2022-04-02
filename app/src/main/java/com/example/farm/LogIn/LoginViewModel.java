package com.example.farm.LogIn;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.farm.MainActivity;
import com.google.firebase.auth.AuthResult;

public class LoginViewModel extends ViewModel implements LoginRepo.loginrepose {
    Context context;

    LoginRepo log = new LoginRepo(this);

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void LogIn(String email, String password) {
        log.Login(email, password);
    }

    @Override
    public void Result() {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public void Error(String error) {
        Toast.makeText(context, "Faild logged in " + error, Toast.LENGTH_LONG).show();
    }
}
