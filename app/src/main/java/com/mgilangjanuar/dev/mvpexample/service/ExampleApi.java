package com.mgilangjanuar.dev.mvpexample.service;

import com.mgilangjanuar.dev.mvpexample.base.BaseApi;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.model.MessageResponseModel;
import com.mgilangjanuar.dev.mvpexample.util.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class ExampleApi extends BaseApi<ExampleApi.Service> {

    @Override
    public String findUrl() {
        return Constant.BASE_URL_EXAMPLE;
    }

    @Override
    public Service create() {
        return build().create(Service.class);
    }

    public interface Service {
        @GET("data")
        Call<MessageResponseModel> getData();
    }
}
