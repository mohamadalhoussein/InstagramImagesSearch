package com.example.student.instagramuserssearch.beans;


public class DataBeanX {



    private String id;
    private String text;
    private String created_time;
    private FromBeanX from;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public FromBeanX getFrom() {
        return from;
    }

    public void setFrom(FromBeanX from) {
        this.from = from;
    }

}
