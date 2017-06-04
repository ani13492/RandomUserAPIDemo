package com.example.aniruddh.randomuser.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aniruddh on 6/2/17.
 * Rerrofit Client Builder Class
 */

public class RetrofitBuilder {
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://randomuser.me/";


    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static APIservice getAPIervice() {
        return RetrofitBuilder.getClient(BASE_URL).create(APIservice.class);
    }
}
