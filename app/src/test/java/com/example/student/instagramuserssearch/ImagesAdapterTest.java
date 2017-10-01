package com.example.student.instagramuserssearch;

import android.support.v7.widget.RecyclerView;

import com.example.student.instagramuserssearch.adapters.ImagesAdapter;
import com.example.student.instagramuserssearch.beans.ThumbnailBean;
import com.example.student.instagramuserssearch.ui.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;




public class ImagesAdapterTest {
    MainActivity mainActivity;
    RecyclerView recyclerView;
    public static final int SIZE = 1;
    public ThumbnailBean item = new ThumbnailBean();
    ImagesAdapter adapter;


    @Before
    public void setUp(){
        mainActivity = new MainActivity();
        recyclerView = (RecyclerView) mainActivity.findViewById(R.id.rv_images);
        adapter = (ImagesAdapter)recyclerView.getAdapter();
        item.setHeight(20);
        item.setWidth(20);
    }
    @Test
    public void testAdapterSize() throws Exception{
        assertEquals(recyclerView.getAdapter().getItemCount(),SIZE);
   }

   @Test
    public void testAdapterItems(){
       assertEquals(adapter.getImages().get(0).getUrl(),item.getUrl());

   }


}
