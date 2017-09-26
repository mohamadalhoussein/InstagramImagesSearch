package com.example.student.instagramuserssearch.api;


import com.example.student.instagramuserssearch.beans.ServerResponse2;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by student on 9/21/2017.
 */

public interface api {


    @GET("{INSTAGRAM_ACCOUNT}/media")
    Observable<ServerResponse2> getUserImages(@Path("INSTAGRAM_ACCOUNT") String userAccount);
}
