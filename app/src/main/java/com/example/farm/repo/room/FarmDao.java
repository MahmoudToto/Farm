package com.example.farm.repo.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.farm.pojo.Farm;

import java.util.List;

@Dao
public interface FarmDao {

    @Insert
    Long insertFarmer(Farm farm);
    @Update
    void UpdateFarmer(Farm farm);
    @Delete
    void DeletFarmer(Farm farm);

    @Query("Select * from Farm_data order by customerName asc")
    LiveData<List<Farm>> getFarmasc();
    @Query("Select * from Farm_data where customerName Like '%' ||:customerName||'%' ")
    LiveData<List<Farm>> getFarmByName(String customerName);
    @Query("Select * from Farm_data where sellerName Like '%' ||:sellerName||'%' ")
    LiveData<List<Farm>>getFarmBySellerName(String sellerName);


}
