package com.example.student.instagramuserssearch.beans;

import io.realm.RealmObject;



public class User extends RealmObject{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
}
