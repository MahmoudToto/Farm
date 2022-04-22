package com.example.farm.ui.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Admin;
import com.example.farm.repo.firebase.AuthInterface;
import com.example.farm.repo.firebase.FireBase;

public class RegisterViewModel extends AndroidViewModel implements AuthInterface {
    private FireBase fireBase;
    private MutableLiveData<Admin> result;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        fireBase = FireBase.getInstance(application);
        result = new MutableLiveData<>();
    }

    public LiveData<Admin> createEmailAdmin(Admin admin){
        fireBase.createEmailAdmin(admin, this);
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
