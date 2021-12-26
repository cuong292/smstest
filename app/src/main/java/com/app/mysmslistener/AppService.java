package com.app.mysmslistener;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {
    @GET("/coffee/hot")
    Observable<List<Coffee>> getCoffee();

    @GET("/coffee/hot")
    Call<List<Coffee>> getCoffee2();
}
