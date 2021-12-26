package com.app.mysmslistener;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

class AppApi {
    public static AppService appService;

    public static AppService getAppService() {
        if (appService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.sampleapis.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            appService = retrofit.create(AppService.class);
        }
        return appService;
    }
}
