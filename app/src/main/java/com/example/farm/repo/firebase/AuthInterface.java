package com.example.farm.repo.firebase;

import com.example.farm.pojo.Admin;

public interface AuthInterface {
    void onSuccess(Admin admin);
    void onFailure(Exception e);
}
