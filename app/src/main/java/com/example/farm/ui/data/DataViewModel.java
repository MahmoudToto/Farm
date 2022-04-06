package com.example.farm.ui.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Admin;
import com.example.farm.pojo.Farm;
import com.example.farm.repo.firebase.DataInterface;
import com.example.farm.repo.firebase.Repo;

public class DataViewModel extends AndroidViewModel implements DataInterface {
    private Repo repo;
    private MutableLiveData<String> result;
    public DataViewModel(@NonNull Application application) {
        super(application);
        repo = Repo.getInstance(application);
        result = new MutableLiveData<>();
    }
    public LiveData<String> registerFarm(Farm farm){
        repo.saveFarm(farm, this);
        return result;

    }

    @Override
    public void onSuccess() {
        result.postValue(null);
    }

    @Override
    public void onFailure(Exception e) {
        result.postValue(e.getMessage());
    }
}
