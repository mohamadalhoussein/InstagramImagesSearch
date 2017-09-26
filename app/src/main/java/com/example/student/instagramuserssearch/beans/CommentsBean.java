package com.example.student.instagramuserssearch.beans;

import java.util.List;


public class CommentsBean {


    private int count;
    private List<DataBeanX> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

}
