package com.example.student.instagramuserssearch.beans;

import java.util.List;



public class ServerResponse2 {


    private boolean more_available;
    private String status;
    private List<ItemsBean> items;

    public boolean isMore_available() {
        return more_available;
    }

    public void setMore_available(boolean more_available) {
        this.more_available = more_available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

}
