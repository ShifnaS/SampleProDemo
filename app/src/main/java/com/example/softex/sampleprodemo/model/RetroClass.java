package com.example.softex.sampleprodemo.model;

import com.example.softex.sampleprodemo.api.APIService;
import com.example.softex.sampleprodemo.api.APIUrl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 3/31/2018.
 */

public class RetroClass {

    private static Retrofit getRetrofitInstance()
    {
        Gson gson =     new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APIService getAPIService()
    {
        return getRetrofitInstance().create(APIService.class);
    }


}
