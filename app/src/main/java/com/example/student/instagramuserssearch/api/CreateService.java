package com.example.student.instagramuserssearch.api;

import android.support.annotation.NonNull;

import com.example.student.instagramuserssearch.beans.ServerResponse2;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by student on 9/21/2017.
 */

public class CreateService {

    private static final String BASE_URL = "https://www.instagram.com/";
    private static CreateService instance;
    private api apiClass;

    private CreateService(){
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiClass = retrofit.create(api.class);


    }
    public static CreateService getInstance() {
        if(instance == null){
            instance = new CreateService();
        }
        return instance;
    }

    public Observable<ServerResponse2> getImages(@NonNull String userAccount) {
        return apiClass.getUserImages(userAccount);
    }
}
