package com.example.student.instagramuserssearch;

import com.example.student.instagramuserssearch.ui.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;




public class MainActivityTest {
    public static final String USERNAME = "username";
    MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = new MainActivity();
        mainActivity.setupSpinner();
    }

    @Test
    public void setUpSpinnerTest(){
        assertEquals(mainActivity.adapter.getItem(0),USERNAME);


    }
}
