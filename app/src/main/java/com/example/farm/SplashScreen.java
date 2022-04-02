package com.example.farm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.farm.LogIn.Login;
import com.example.farm.Register.Register;
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
            startActivity(new Intent(this, Login.class));
        } else {
            Log.i("Splash", "User is here : " + mAuth.getCurrentUser().getUid());
            startActivity(new Intent(this, MainActivity.class));
        }

    }

}