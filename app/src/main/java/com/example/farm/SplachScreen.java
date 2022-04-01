package com.example.farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.farm.LogIn.Login;
import com.example.farm.Register.Register;
import com.google.firebase.auth.FirebaseAuth;

public class SplachScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splach_screen);
        if(FirebaseAuth.getInstance().getCurrentUser()!= null) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            startActivity(new Intent(this, Register.class));

        }
    }

}