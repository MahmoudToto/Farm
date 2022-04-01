package com.example.farm;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.farm.LogIn.LoginViewModel;
import com.example.farm.Register.RegisterViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private Context context;

    public ViewModelFactory(Context context) {
        this.context = context;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(RegisterViewModel.class)){
            return (T) new RegisterViewModel(context);
        }else if(modelClass.isAssignableFrom(LoginViewModel.class)){
            return (T) new LoginViewModel(context);
        }
        else {
            throw new IllegalArgumentException("UN known ");
        }
    }
}