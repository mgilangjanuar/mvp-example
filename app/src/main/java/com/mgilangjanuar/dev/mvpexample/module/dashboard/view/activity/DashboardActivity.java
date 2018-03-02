package com.mgilangjanuar.dev.mvpexample.module.dashboard.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.mgilangjanuar.dev.mvpexample.R;
import com.mgilangjanuar.dev.mvpexample.base.BaseActivity;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.model.MessageResponseModel;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.presenter.DashboardPresenter;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.view.adapter.DashboardAdapter;

import butterknife.BindView;

public class DashboardActivity extends BaseActivity implements DashboardPresenter.DashboardPresenterListener {

    @BindView(R.id.list)
    RecyclerView list;

    private DashboardPresenter presenter = new DashboardPresenter(this);

    @Override
    public int findLayout() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupRecyclerView(list, false);
        presenter.retrieveMessages();
    }

    @Override
    public void onError(String error) {
        showSnackbar(error);
    }

    @Override
    public void onSuccess(MessageResponseModel model) {
        list.setAdapter(new DashboardAdapter(model.data));
    }
}
