package com.example.student.instagramuserssearch.presenters;


import android.util.Log;

import com.example.student.instagramuserssearch.api.CreateService;
import com.example.student.instagramuserssearch.beans.ServerResponse2;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.example.student.instagramuserssearch.interfaces.MainActivityCallback;


import java.util.ArrayList;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.Observer;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by student on 9/20/2017.
 */

public class MainActivityPresenter {
    private static final String TAG = MainActivityPresenter.class.getSimpleName();
    private final MainActivityCallback callback;
    private final CompositeSubscription subscriptions;
    ArrayList<ThumbnailBean> images = new ArrayList<>();


    public MainActivityPresenter(MainActivityCallback callback) {
        this.callback = callback;
        this.subscriptions = new CompositeSubscription();
    }

    public void getImagesUrls() {
        callback.showProgress();
        Subscription subscription = (Subscription) CreateService.getInstance().getImages(callback.getUserName())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ServerResponse2>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                        callback.hideProgress();
                        callback.addUserToSpinner();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError"+ e.getMessage());
                        callback.hideProgress();
                    }

                    @Override
                    public void onNext(ServerResponse2 serverResponse) {
                        for (int i = 0; i < serverResponse.getItems().size(); i++) {
                            if (!images.contains(serverResponse.getItems().get(i).getImages().getThumbnail())) {
                                images.add(serverResponse.getItems().get(i).getImages().getThumbnail());
                            }
                        }

                        callback.getListSuccess(images);


                    }
                });
        subscriptions.add(subscription);

    }


}






