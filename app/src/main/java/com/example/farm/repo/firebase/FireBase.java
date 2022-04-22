package com.example.farm.repo.firebase;

import android.app.Application;
import androidx.annotation.NonNull;
import com.example.farm.pojo.Admin;
import com.example.farm.pojo.Farm;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class FireBase {

    private String Id = "id",
            Name = "name",
            Area = "area",
            SellerName = "seller name",
            PlantType = "plant",
            Number ="number";

    private static FireBase sInstance;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private FireBase(Application application) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public static FireBase getInstance(Application application){
        if(sInstance == null){
            synchronized (FireBase.class){
                if(sInstance == null){
                    sInstance = new FireBase(application);
                }
            }
        }
        return sInstance;
    }
// To log in
    public void login(Admin admin, AuthInterface authInterface){
        firebaseAuth.signInWithEmailAndPassword(admin.getEmail().trim(), admin.getPassword().trim()).
            addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    authInterface.onSuccess(admin);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    authInterface.onFailure(e);
                }
            });

    }
// To creat Email
    public void createEmailAdmin(Admin user, AuthInterface authInterface){
        firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword())
            .addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    task.getResult().getUser().sendEmailVerification();

//                    task.getResult()
//                            .getUser()
//                            .updatePhoneNumber(PhoneAuthProvider
//                                    .getCredential(verificationId, code));
                    authInterface.onSuccess(user);
                }else{
                    authInterface.onFailure(task.getException());
                }
            });
    }

    public Admin getAdmin(){
        if(firebaseAuth.getCurrentUser().isAnonymous())
            return null;
        return new Admin(
                firebaseAuth.getCurrentUser().getUid(),
                firebaseAuth.getCurrentUser().getEmail(),
                firebaseAuth.getCurrentUser().getPhoneNumber());

    }
    /// to save Data from firebase
    public void saveFarm(Farm farm, DataInterface dataInterface) {
        Map<String,Object> dataTosave = new HashMap<>();
        dataTosave.put(Name,farm.getCustomerName());
        dataTosave.put(Number,farm.getCustomerNumber());
        dataTosave.put(Area, farm.getArea());
        dataTosave.put(SellerName,farm.getSellerName());
        dataTosave.put(PlantType,farm.getPlantType());
        firebaseFirestore.collection("user/"+firebaseAuth.getCurrentUser().getUid()+"/data")
                .document()
                .set(dataTosave)
                .addOnSuccessListener(unused -> dataInterface.onSuccess())
                .addOnFailureListener(e -> dataInterface.onFailure(e));
    }



}
