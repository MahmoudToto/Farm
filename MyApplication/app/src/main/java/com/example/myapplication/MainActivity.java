package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_main);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat(R.drawable.cat,"Cat 1"));
        cats.add(new Cat(R.drawable.cat1,"Cat 2"));
        cats.add(new Cat(R.drawable.cat2,"Cat 3"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(cats);
        RecyclerView.LayoutManager m1 = new LinearLayoutManager(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(m1);
        rv.setAdapter(adapter);

    }
}