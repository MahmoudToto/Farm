package com.example.farm.repo.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.farm.pojo.Farm;

import java.util.List;

public class RepoRoom {
    FarmDao farmDao;

    public RepoRoom(Application application){
        FarmeData db = FarmeData.getDatabase(application);
        farmDao = db.farmDao();
    }


    public void insertFarmer(Farm farm, RoomInterface roomInterface){
        FarmeData.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                roomInterface.onSuccess(farmDao.insertFarmer(farm));

            }
        });
    }

    public void UpdateFarmer(Farm farm){
        FarmeData.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                farmDao.UpdateFarmer(farm);
            }
        });
    }

    public void DeletFarmer(Farm farm){
        FarmeData.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                farmDao.DeletFarmer(farm);
            }
        });
    }

    public LiveData<List<Farm>> getFarmasc(){
        return farmDao.getFarmasc();
    }
    public LiveData<List<Farm>> getFarmByName(String customerName){
        return farmDao.getFarmByName(customerName);
    }
    public LiveData<List<Farm>>getFarmBySellerName(String sellerName){
        return farmDao.getFarmBySellerName(sellerName);
    }


}
