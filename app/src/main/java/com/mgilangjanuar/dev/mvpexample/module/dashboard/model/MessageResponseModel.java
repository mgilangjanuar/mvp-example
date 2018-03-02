package com.mgilangjanuar.dev.mvpexample.module.dashboard.model;

import com.mgilangjanuar.dev.mvpexample.base.BaseResponse;
import com.mgilangjanuar.dev.mvpexample.service.ExampleApi;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class MessageResponseModel extends BaseResponse {

    public List<MessageModel> data;

    public static void retrieveData(Callback<MessageResponseModel> callback) {
        new ExampleApi().create().getData().enqueue(callback);
    }

    public static class MessageModel {
        public String from;
        public String message;
    }
}
