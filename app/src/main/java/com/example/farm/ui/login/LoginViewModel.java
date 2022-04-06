package com.example.farm.ui.login;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Admin;
import com.example.farm.repo.firebase.AuthInterface;
import com.example.farm.repo.firebase.Repo;

import java.util.HashMap;

public class LoginViewModel extends AndroidViewModel implements AuthInterface {
    private Repo repo;
    private MutableLiveData<Admin> result;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        repo = Repo.getInstance(application);
        result = new MutableLiveData<>();
    }
    public LiveData<Admin> login(Admin admin){
        repo.login(admin, this);
        return result;

    }

    @Override
    public void onSuccess(Admin admin) {
        result.postValue(admin);
    }

    @Override
    public void onFailure(Exception e) {
        result.postValue(null);
    }
}
