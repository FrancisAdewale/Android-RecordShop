package com.northcoders.recordshop.service;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;

    private static final String BASE_URL = "http://recordshopapi-env.eba-k5wd2zru.eu-west-2.elasticbeanstalk.com/api/v1/";

    public static AlbumApiService getService() {
        if(retrofit == null) {
           retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(AlbumApiService.class);
    }
}
