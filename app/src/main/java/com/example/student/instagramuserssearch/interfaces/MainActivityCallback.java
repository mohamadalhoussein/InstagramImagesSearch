package com.example.student.instagramuserssearch.interfaces;

import com.example.student.instagramuserssearch.beans.ThumbnailBean;

import java.util.List;



public interface MainActivityCallback {

    void showProgress();
    void hideProgress();

    void getListSuccess(List<ThumbnailBean> thumbnail);

    String getUserName();

    void addUserToSpinner();
}
