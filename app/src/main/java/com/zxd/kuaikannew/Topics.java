package com.zxd.kuaikannew;

import java.util.ArrayList;
import java.util.List;
public class Topics
{
    private int id;

    private String cover_image_url;

    private String vertical_image_url;

    private String square_image_url;

    private String title;

    private String description;

    private String likes_count;

    private List<String> tags;

    private User user;

    private String signing_status;

    private String update_remind;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setCover_image_url(String cover_image_url){
        this.cover_image_url = cover_image_url;
    }
    public String getCover_image_url(){
        return this.cover_image_url;
    }
    public void setVertical_image_url(String vertical_image_url){
        this.vertical_image_url = vertical_image_url;
    }
    public String getVertical_image_url(){
        return this.vertical_image_url;
    }
    public void setSquare_image_url(String square_image_url){
        this.square_image_url = square_image_url;
    }
    public String getSquare_image_url(){
        return this.square_image_url;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setLikes_count(String likes_count){
        this.likes_count = likes_count;
    }
    public String getLikes_count(){
        return this.likes_count;
    }
    public void setTags(List<String> tags){
        this.tags = tags;
    }
    public List<String> getTags(){
        return this.tags;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setSigning_status(String signing_status){
        this.signing_status = signing_status;
    }
    public String getSigning_status(){
        return this.signing_status;
    }
    public void setUpdate_remind(String update_remind){
        this.update_remind = update_remind;
    }
    public String getUpdate_remind(){
        return this.update_remind;
    }
}