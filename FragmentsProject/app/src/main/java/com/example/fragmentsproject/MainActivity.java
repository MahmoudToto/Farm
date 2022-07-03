package com.example.fragmentsproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_x, btny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_x =  findViewById(R.id.main_btn_x);
        btny = findViewById(R.id.main_btn_y);

        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                XFragment fragment = new XFragment();
                ft.add(R.id.fragment_container,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        btny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                YFragment fragment = new YFragment();
                ft.add(R.id.fragment_container,fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}