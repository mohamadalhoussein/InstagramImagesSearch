package com.example.student.instagramuserssearch;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.example.student.instagramuserssearch.api.CreateService;
import com.example.student.instagramuserssearch.beans.ServerResponse2;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.example.student.instagramuserssearch.presenters.MainActivityPresenter;
import com.example.student.instagramuserssearch.ui.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;

import rx.observers.TestSubscriber;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.equalTo;
import static android.support.test.espresso.core.deps.guava.base.Splitter.on;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasEntry;
import static org.mockito.Mockito.mock;



@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private MainActivityPresenter mMockPresenter;
    public ThumbnailBean item = new ThumbnailBean();
    final static String USERNAME = "username";
    CreateService service;



    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<MainActivity>(MainActivity.class,false,false);


    @Test
    public void spinnerTextUpdateTest(){
        String givenString = "ali2735";

        onView(withId(R.id.unames_spinner)).check(matches(isDisplayed()));
        onView(withText(givenString)).check(matches(withParent(withId(R.id.unames_spinner))));

    }

    @Test
    public void recyclerViewTest(){
        String url = "\"https://scontent-mxp1-1.…27824821073084416_n.jpg\"";
        String lastUrl = "\"https://scontent-mxp1-1.…103192_1374305946_n.jpg\"";
        onView(withId(R.id.rv_images)).check(matches(hasDescendant(withText(url))));
        onView(withText(url)).check(doesNotExist());
        onView(withText(lastUrl)).check(matches(isCompletelyDisplayed())); //check last item displayed



    }
    @Test
    public void searchButtonTest(){
        onView(withId(R.id.btn_search)).check(matches(isClickable()));
        onView(withId(R.id.btn_search)).perform(click());


    }

}

