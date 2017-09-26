package com.example.student.instagramuserssearch.beans;


public class ImagesBean {


    private ThumbnailBean thumbnail;
    private LowResolutionBean low_resolution;
    private StandardResolutionBean standard_resolution;

    public ThumbnailBean getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ThumbnailBean thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LowResolutionBean getLow_resolution() {
        return low_resolution;
    }

    public void setLow_resolution(LowResolutionBean low_resolution) {
        this.low_resolution = low_resolution;
    }

    public StandardResolutionBean getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(StandardResolutionBean standard_resolution) {
        this.standard_resolution = standard_resolution;
    }

}
