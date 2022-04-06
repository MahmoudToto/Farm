package com.example.farm.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.farm.R;
import com.example.farm.ui.login.LoginActivity;
import com.example.farm.ui.main.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splach_screen);

        mAuth = FirebaseAuth.getInstance();
        checkForUser();

    }

    private void checkForUser() {
        if(mAuth.getCurrentUser() == null) {
            // -- Send user to login
            Log.i("Splash", "User is null");
            startActivity(new Intent(this, LoginActivity.class));

        } else {
            Log.i("Splash", "User is here : " + mAuth.getCurrentUser().getUid());
            startActivity(new Intent(this, MainActivity.class));

        }
        finish();
    }

}