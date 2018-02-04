package com.note.cesar.weatherfinal.api;

import com.note.cesar.weatherfinal.model.CurrentConditionModel;
import com.note.cesar.weatherfinal.model.GeoPositionModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by shekh on 04-02-2018.
 */

public interface ApiInterface {

    @GET("/locations/v1/cities/geoposition/search")
    Call<GeoPositionModel> getKey(@Query("apikey") String key, @Query("q") String latLong);


    @GET("/currentconditions/v1/{key}")
    Call<List<CurrentConditionModel.Temperature>> getWeather(@Path("key") String cityKey, @Query("apikey") String appId);

}
