package com.mgilangjanuar.dev.mvpexample.module.dashboard.presenter;

import com.mgilangjanuar.dev.mvpexample.base.BaseResponseListener;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.model.MessageResponseModel;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.view.adapter.DashboardAdapter;
import com.mgilangjanuar.dev.mvpexample.service.ExampleApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class DashboardPresenter {

    private DashboardPresenterListener listener;

    public DashboardPresenter(DashboardPresenterListener listener) {
        this.listener = listener;
    }

    public void retrieveDataMessages() {
        ExampleApi.create().getData().enqueue(new Callback<MessageResponseModel>() {
            @Override
            public void onResponse(Call<MessageResponseModel> call, Response<MessageResponseModel> response) {
                listener.onSuccess(new DashboardAdapter(response.body().data));
            }

            @Override
            public void onFailure(Call<MessageResponseModel> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public static interface DashboardPresenterListener extends BaseResponseListener {
        void onSuccess(DashboardAdapter adapter);
    }
}
