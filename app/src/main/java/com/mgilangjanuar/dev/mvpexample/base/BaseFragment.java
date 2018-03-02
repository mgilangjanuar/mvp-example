package com.mgilangjanuar.dev.mvpexample.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public abstract class BaseFragment extends Fragment {

    @LayoutRes
    public abstract int findLayout();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(findLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}
