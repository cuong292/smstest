package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {
    @GET("/coffee/hot")
    Call<List<Coffee>> getCoffee();
}
