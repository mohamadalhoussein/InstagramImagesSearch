package com.example.student.instagramuserssearch.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.example.student.instagramuserssearch.R;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by student on 9/20/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public ProgressDialog mProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgress = new ProgressDialog(this);
        mProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgress.setMessage(getString(R.string.loading));
        mProgress.setCancelable(false);
        mProgress.setCanceledOnTouchOutside(false);
    }



    public Activity getActivity() {
        return this;
    }




    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }
}
