package com.example.aniruddh.randomuser.api;

import com.example.aniruddh.randomuser.Model.User;
import com.example.aniruddh.randomuser.api.ApiModel.RandomUserResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Aniruddh on 6/2/17.
 * API request Interface
 */

public interface APIservice {

    /**
     * @param results the number of results (users) to generate
     * @return An Observable object that contains the response
     */
    @GET("/api/")
    Observable<RandomUserResponse> getRandomUsers(@Query("results") Integer results);


}
