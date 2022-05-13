package com.example.farm.ui.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farm.pojo.Farm;
import com.example.farm.repo.firebase.DataInterface;
import com.example.farm.repo.firebase.FireBase;
import com.example.farm.repo.room.RepoRoom;
import com.example.farm.repo.room.RoomInterface;

import java.util.List;

public class DataViewModel extends AndroidViewModel implements DataInterface, RoomInterface {
    private RepoRoom roomBase;
    private FireBase fireBase;
    private MutableLiveData<String> result;
    private MutableLiveData<Long> resultId;
    public DataViewModel(@NonNull Application application) {
        super(application);
        fireBase = FireBase.getInstance(application);
        roomBase = new RepoRoom(application);
        result = new MutableLiveData<>();
        resultId = new MutableLiveData<>();
    }
    public LiveData<String> registerFarm(Farm farm){
        fireBase.saveFarm(farm, this);
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


   // Room Data Base >>>>>>>check With Hicham
    public LiveData<Long> insertFarmer(Farm farm){
        roomBase.insertFarmer(farm, this);
        return resultId;

    }

    @Override
    public void onSuccess(Long l) {
        resultId.postValue(l);
    }

    public void UpdateFarmer(Farm farm){
        roomBase.UpdateFarmer(farm);
    }

    public void DeletFarmer(Farm farm){
        roomBase.DeletFarmer(farm);
    }

    public LiveData<List<Farm>> getFarmasc(){
        return roomBase.getFarmasc();
    }

    public LiveData<List<Farm>> getFarmByName(String customerName){
        return roomBase.getFarmByName(customerName);
    }

    public LiveData<List<Farm>>getFarmBySellerName(String sellerName){
        return roomBase.getFarmBySellerName(sellerName);
    }

}

