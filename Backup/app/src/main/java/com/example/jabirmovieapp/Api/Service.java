package com.example.jabirmovieapp.Api;

import com.example.jabirmovieapp.Model.moviesResponceModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/now_playing")
    Call<moviesResponceModel> getNowPlaying(@Query("api_key") String apiKey);

}
