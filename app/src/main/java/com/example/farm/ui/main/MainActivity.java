package com.example.farm.ui.main;

import static java.util.Locale.filter;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.farm.R;

import com.example.farm.pojo.Farm;
import com.example.farm.ui.data.DataActivity;
import com.example.farm.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private FloatingActionButton fabAdd;
    private RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    MainViewModel viewModel;
    List<Farm> list = new ArrayList<>();
SearchView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        recyclerView = findViewById(R.id.main_recyclerview);
        toolbar = findViewById(R.id.main_toolbar);
        fabAdd = findViewById(R.id.main_fab_add);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
//ctr -->shift   -->Up


        viewModel.getFarmasc().observe(this, new Observer<List<Farm>>() {
            @Override
            public void onChanged(List<Farm> farms) {
                populateDataIntoRV(farms);
            }
        });


        ActivityResultLauncher<Intent> ar1 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                    }
                }
        );

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                ar1.launch(intent);

            }
        });




    }


// For Select item in Action Barr
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        MenuItem searchItem = menu.findItem(R.id.menu_Search);
//        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_log_out:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menu_Search:
mSearchView .setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filter(newText);
                    return true;
                }

    private void filter(String newText) {
      List<Farm> listfoodsearch = new ArrayList<>();
        for (Farm farm : list) {
            if (farm.getCustomerName().toLowerCase().contains(newText.toLowerCase())) {
                listfoodsearch.add(farm);
            }

        }
//        adapter.filterlist(listfoodsearch);
    }

});
                break;
        }

        return super.onOptionsItemSelected(item);
}

// For Edit or delete item in recycler view

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edite,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_edit:

                break;

            case R.id.menu_delete:

                break;
        }
        return super.onContextItemSelected(item);
    }

    void populateDataIntoRV(List<Farm> farms) {
        adapter = new RecyclerViewAdapter(farms);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

}




