package com.example.farm.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Farm;
import com.example.farm.repo.firebase.MainInterface;
import com.example.farm.repo.firebase.FireBase;


public class MainViewModel extends AndroidViewModel implements MainInterface {
    private FireBase fireBase;
    private MutableLiveData<Farm> result;
    public MainViewModel(@NonNull Application application) {
        super(application);
        fireBase = FireBase.getInstance(application);
        result = new MutableLiveData<>();
    }



}