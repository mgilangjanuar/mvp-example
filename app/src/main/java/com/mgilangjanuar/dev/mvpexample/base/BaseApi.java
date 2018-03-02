package com.mgilangjanuar.dev.mvpexample.base;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public abstract class BaseApi<E> {

    public abstract String findUrl();

    public abstract E create();

    protected Retrofit build() {
        return new Retrofit.Builder()
                .baseUrl(findUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
