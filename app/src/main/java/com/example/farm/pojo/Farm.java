package com.example.farm.pojo;

public class Farm {
String customer_name, area, plant_type,seller_name;

    public Farm(String customer_name, String area, String plante_type, String seller_name) {
        this.customer_name = customer_name;
        this.area = area;
        this.plant_type = plante_type;
        this.seller_name = seller_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getArea() {
        return area;
    }

    public String getPlante_type() {
        return plant_type;
    }

    public String getSeller_name() {
        return seller_name;
    }
}
