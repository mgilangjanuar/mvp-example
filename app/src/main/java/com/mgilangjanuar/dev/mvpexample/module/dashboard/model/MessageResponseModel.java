package com.mgilangjanuar.dev.mvpexample.module.dashboard.model;

import com.mgilangjanuar.dev.mvpexample.base.BaseResponse;

import java.util.List;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class MessageResponseModel extends BaseResponse {

    public List<MessageModel> data;

    public static class MessageModel {
        public String from;
        public String message;
    }
}
