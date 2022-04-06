package com.example.farm.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
    private String name, email,number,password,id;
    private boolean active = true;

    public Admin(String name, String email, String number, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public Admin(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
