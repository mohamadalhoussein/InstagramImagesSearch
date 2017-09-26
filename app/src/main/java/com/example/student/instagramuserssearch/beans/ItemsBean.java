package com.example.student.instagramuserssearch.beans;


public class ItemsBean {


    private String id;
    private String code;
    private UserBean user;
    private ImagesBean images;
    private String created_time;
    private CaptionBean caption;
    private boolean user_has_liked;
    private LikesBean likes;
    private CommentsBean comments;
    private boolean can_view_comments;
    private boolean can_delete_comments;
    private String type;
    private String link;
    private LocationBean location;
    private Object alt_media_url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public CaptionBean getCaption() {
        return caption;
    }

    public void setCaption(CaptionBean caption) {
        this.caption = caption;
    }

    public boolean isUser_has_liked() {
        return user_has_liked;
    }

    public void setUser_has_liked(boolean user_has_liked) {
        this.user_has_liked = user_has_liked;
    }

    public LikesBean getLikes() {
        return likes;
    }

    public void setLikes(LikesBean likes) {
        this.likes = likes;
    }

    public CommentsBean getComments() {
        return comments;
    }

    public void setComments(CommentsBean comments) {
        this.comments = comments;
    }

    public boolean isCan_view_comments() {
        return can_view_comments;
    }

    public void setCan_view_comments(boolean can_view_comments) {
        this.can_view_comments = can_view_comments;
    }

    public boolean isCan_delete_comments() {
        return can_delete_comments;
    }

    public void setCan_delete_comments(boolean can_delete_comments) {
        this.can_delete_comments = can_delete_comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public Object getAlt_media_url() {
        return alt_media_url;
    }

    public void setAlt_media_url(Object alt_media_url) {
        this.alt_media_url = alt_media_url;
    }

}
