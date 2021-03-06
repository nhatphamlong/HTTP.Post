package com.example.httppost.retroAPI;

import com.example.httppost.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("/posts")
    @FormUrlEncoded
    //Call<Post> savePost (@Body Post post)
    Call<Post> savePost(@Field("Username") String username,
                        @Field("Pass") String pass,
                        @Field("userID") long userID);

}
