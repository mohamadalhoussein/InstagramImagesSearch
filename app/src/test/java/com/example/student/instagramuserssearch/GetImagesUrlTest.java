package com.example.student.instagramuserssearch;

import com.example.student.instagramuserssearch.api.CreateService;
import com.example.student.instagramuserssearch.beans.ServerResponse2;

import org.junit.Before;
import org.junit.Test;

import rx.observers.TestSubscriber;
import static org.junit.Assert.*;




public class GetImagesUrlTest {
    private static final String USERNAME = "username";

    CreateService service;

    @Before
    public void setUp(){
        service = CreateService.getInstance();
    }
    @Test
    public void testImagesUrls() throws Exception{
        TestSubscriber<ServerResponse2> subscriber = TestSubscriber.create();
        service.getImages(USERNAME).subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertCompleted();
        assertEquals(subscriber.getOnNextEvents().get(0).getItems().get(0).getImages().getThumbnail().getUrl(),USERNAME);


    }
}
