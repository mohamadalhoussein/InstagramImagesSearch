package com.example.student.instagramuserssearch.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.student.instagramuserssearch.R;
import com.example.student.instagramuserssearch.adapters.ImagesAdapter;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.example.student.instagramuserssearch.beans.User;
import com.example.student.instagramuserssearch.interfaces.MainActivityCallback;
import com.example.student.instagramuserssearch.presenters.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Subscription;


public class MainActivity extends BaseActivity implements MainActivityCallback, View.OnClickListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.et_uesrname)
    EditText username;

    @BindView(R.id.rv_images)
    RecyclerView imagesList;

    @BindView(R.id.unames_spinner)
    Spinner usersSpinner;

    @BindView(R.id.btn_search)
    Button btn_search;

    Subscription subscription;
    ArrayList<String> usernamesHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        search = (Button) findViewById(R.id.btn_search);
//        username = (EditText) findViewById(R.id.et_uesrname);
        btn_search.setOnClickListener(this);
        imagesList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //imagesList.setLayoutManager(new GridLayoutManager(this,2));
        Realm.init(this);

        setupSpinner();
        usersSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public void showProgress() {
        mProgress.show();


    }

    @Override
    public void hideProgress() {
        mProgress.hide();


    }

    @Override
    public void getListSuccess(List<ThumbnailBean> thumbnail) {
        ImagesAdapter adapter = new ImagesAdapter(getActivity(), thumbnail);
        imagesList.setAdapter(adapter);


    }


    @Override
    public String getUserName() {
        return username.getText().toString().trim();
    }

    @Override
    public void addUserToSpinner() {
        Realm realm = Realm.getDefaultInstance();
        User userInDataBase = realm.where(User.class).equalTo("userName", getUserName()).findFirst();

        if (userInDataBase == null){
            realm.beginTransaction();
            User user = realm.createObject(User.class);
            user.setUserName(getUserName());
            realm.commitTransaction();
            setupSpinner();
        }
    }

    private void setupSpinner() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> result = realm.where(User.class)
                .findAll();
        usernamesHistory.clear();
        for (User user :
                result) {
            if (!usernamesHistory.contains(user.getUserName())){
                usernamesHistory.add(user.getUserName());
            }
        }
        SpinnerAdapter spinnerAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usernamesHistory);
        usersSpinner.setAdapter(spinnerAdapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                doSearch();
                break;
        }
    }

    private void doSearch() {
        MainActivityPresenter presenter = new MainActivityPresenter(this);
        presenter.getImagesUrls();
        hideSoftKeyboard();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> result = realm.where(User.class)
                .findAll();
        User user = result.get(position);
        username.setText(user.getUserName());
        doSearch();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
