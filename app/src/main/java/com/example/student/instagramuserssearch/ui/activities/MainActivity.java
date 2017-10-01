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
import com.example.student.instagramuserssearch.R;
import com.example.student.instagramuserssearch.adapters.ImagesAdapter;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.example.student.instagramuserssearch.beans.User;
import com.example.student.instagramuserssearch.interfaces.MainActivityCallback;
import com.example.student.instagramuserssearch.presenters.MainActivityPresenter;
import com.google.gson.JsonElement;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.deepstream.DeepstreamClient;
import io.deepstream.DeepstreamFactory;
import io.deepstream.DeepstreamRuntimeErrorHandler;
import io.deepstream.Event;
import io.deepstream.MergeStrategy;
import io.deepstream.Record;
import io.deepstream.RecordPathChangedCallback;
import io.deepstream.Topic;
import io.realm.Realm;
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

    public ArrayAdapter<String> adapter;
    ArrayList<String> usernamesHistory = new ArrayList<>();
     DeepstreamClient client=null ;
    DeepstreamFactory factory;
    Record record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn_search.setOnClickListener(this);
        imagesList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Realm.init(this);

        factory= DeepstreamFactory.getInstance();
        try {
            client = factory.getClient("wss://035.deepstreamhub.com?apiKey=278d97d1-175c-4bed-a013-1c87712db35f");
            client.setRuntimeErrorHandler(new DeepstreamRuntimeErrorHandler() {
               @Override
              public void onException(Topic topic, Event event, String s) {
                  //xToast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();

              }
           });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        client.login();

        setupSpinner();

        record= client.record.getRecord("username-record");
        record.setMergeStrategy(MergeStrategy.REMOTE_WINS);

        usersSpinner.setOnItemSelectedListener(this);

        record.subscribe("username", new RecordPathChangedCallback() {
            @Override
            public void onRecordPathChanged(String s, String s1, JsonElement jsonElement) {
                if( jsonElement.isJsonNull()){
                    return;
                }
                usersSpinner.setSelection((adapter.getPosition(jsonElement.getAsString())));
            }
        });

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

    public void setupSpinner() {
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
        adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, usernamesHistory);
        usersSpinner.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                doSearch();
                break;
        }
    }

    public void doSearch() {
        MainActivityPresenter presenter = new MainActivityPresenter(this);
        presenter.getImagesUrls();
        hideSoftKeyboard();

    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, View view, final int position, long id) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> result = realm.where(User.class)
                .findAll();
        User user = result.get(position);
        username.setText(user.getUserName());
        record.set("username",parent.getAdapter().getItem(position));



        doSearch();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
