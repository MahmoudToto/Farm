package com.example.farm.Register;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.farm.LogIn.Login;
import com.example.farm.MainActivity;
import com.example.farm.pojo.Admin;

public class RegisterViewModel extends ViewModel implements Repo.SentData {
    Context context;
    Repo repo = new Repo(this);

    public RegisterViewModel(Context context) {
        this.context = context;
    }
    public void CreateEmailandSavindData(Admin user, String email, String password){
        repo.CreateEmailAdmin(user,email,password);
    }

    @Override
    public void Successed() {
context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    public void Error(String error) {
        Toast.makeText(context, "Error" + error, Toast.LENGTH_SHORT).show();
    }

}
