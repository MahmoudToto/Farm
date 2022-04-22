package com.example.farm.pojo;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Farm_data")
public class Farm {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String customerName, area, plantType,sellerName, customerNumber;

    public Farm(long id, String customerName, String area, String plantType, String sellerName, String customerNumber) {
        this.id = id;
        this.customerName = customerName;
        this.area = area;
        this.plantType = plantType;
        this.sellerName = sellerName;
        this.customerNumber = customerNumber;
    }

    @Ignore
    public Farm(String customerName, String area, String plantType, String sellerName, String customerNumber) {
        this.customerName = customerName;
        this.area = area;
        this.plantType = plantType;
        this.sellerName = sellerName;
        this.customerNumber = customerNumber;
    }

    public Farm() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
