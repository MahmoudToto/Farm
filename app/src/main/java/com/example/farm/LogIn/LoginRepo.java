package com.example.farm.LogIn;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginRepo {
    loginrepose inter;
    FirebaseAuth auth;
    public LoginRepo(loginrepose inter) {
        this.inter = inter;
    }
    public void Login(String email, String passowrd) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, passowrd).
                addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        inter.Result();
                    } else {
                        inter.Error(task.getException().getMessage());
                    }

                });
    }
    interface loginrepose {
        void Result();
        void Error(String error);

    }

}
