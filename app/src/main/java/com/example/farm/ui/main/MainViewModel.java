package com.example.farm.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Farm;
import com.example.farm.repo.firebase.MainInterface;
import com.example.farm.repo.firebase.FireBase;
import com.example.farm.repo.room.ReboRoom;
import com.example.farm.repo.room.RoomInterface;

import java.util.List;


public class MainViewModel extends AndroidViewModel implements MainInterface {
    private FireBase fireBase;
    ReboRoom reboRoom;
    private MutableLiveData<Farm> result;
    public MainViewModel(@NonNull Application application) {
        super(application);
        reboRoom = new ReboRoom(application);
        fireBase = FireBase.getInstance(application);
        result = new MutableLiveData<>();
    }
    public void insertFarmer(Farm farm, RoomInterface roomInterface){
        reboRoom.insertFarmer(farm, roomInterface);
    }

    public void UpdateFarmer(Farm farm){
        reboRoom.UpdateFarmer(farm);
    }

    public void DeletFarmer(Farm farm){
        reboRoom.DeletFarmer(farm);
    }

    public LiveData<List<Farm>> getFarmasc(){
        return reboRoom.getFarmasc();
    }
    public LiveData<List<Farm>> getFarmByName(String customerName){
        return reboRoom.getFarmByName(customerName);
    }
    public LiveData<List<Farm>>getFarmBySellerName(String sellerName){
        return reboRoom.getFarmBySellerName(sellerName);
    }


}