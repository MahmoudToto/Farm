package com.example.farm.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Admin;
import com.example.farm.pojo.Farm;
import com.example.farm.repo.firebase.MainInterface;
import com.example.farm.repo.firebase.Repo;


public class MainViewModel extends AndroidViewModel implements MainInterface {
    private Repo repo;
    private MutableLiveData<Farm> result;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repo = Repo.getInstance(application);
        result = new MutableLiveData<>();
    }



}