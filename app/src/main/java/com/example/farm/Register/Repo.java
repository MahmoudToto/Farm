package com.example.farm.Register;

import android.content.Context;
import android.content.Intent;

import com.example.farm.MainActivity;
import com.example.farm.pojo.Admin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Repo {
    SentData sentData ;
    FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();

    public Repo(SentData sentData) {
        this.sentData = sentData;
    }

    DatabaseReference databaseReference=firebaseDatabase.getReference("Admin");


    public void CreateEmailAdmin(Admin user, String email, String password){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete( Task<AuthResult> task) {
                        if(task.isSuccessful()){
                         user.setId(FirebaseAuth.getInstance().getCurrentUser().getUid());
                            SavingData(user);
                            sentData.Successed();
                        }else{
                            sentData.Error(task.getException().getMessage());
                        }
                    }
                });
    }
    private void SavingData(Admin userAd) {
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databaseReference.child(uid).setValue(userAd)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete( Task<Void> task) {
                        if(task.isSuccessful()){
                            sentData.Successed();
                        }else{
                            sentData.Error(task.getException().getMessage());
                        }
                    }
                });


    }
    public interface SentData{
        void Successed();
        void Error(String er);
    }

}
