package com.mgilangjanuar.dev.mvpexample.service;

import com.mgilangjanuar.dev.mvpexample.module.dashboard.model.MessageResponseModel;
import com.mgilangjanuar.dev.mvpexample.util.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class ExampleApi {

    private static String baseUrl = Constant.BASE_URL_EXAMPLE;

    private static Retrofit adapter = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Service create() {
        Service result = adapter.create(Service.class);
        baseUrl = Constant.BASE_URL_EXAMPLE;
        adapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return result;
    }

    public static void setBaseUrl(String baseUrl) {
        ExampleApi.baseUrl = baseUrl;
        adapter = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public interface Service {

        @GET("data")
        Call<MessageResponseModel> getData();
    }
}
