package com.example.httppost.retroAPI;

public class ApiUtils {
    private ApiUtils(){}
    public static final String Base_URL = "https://jsonplaceholder.typicode.com/";
    public static RetrofitAPI getRetrofitAPI(){
        return RetrofitClient.getClient(Base_URL).create(RetrofitAPI.class);
    }
}
