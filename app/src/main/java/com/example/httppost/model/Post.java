package com.example.httppost.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Pass")
    @Expose
    private String pass;
    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Username='" + username + '\'' +
                ", Pass='" + pass+ '\'' +
                ", userID=" + userID +
                ", id=" + id +
                '}';
    }

}
