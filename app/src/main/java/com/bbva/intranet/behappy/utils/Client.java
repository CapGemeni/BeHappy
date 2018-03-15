package com.bbva.intranet.behappy.utils;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DANIEGAR on 09/03/2018.
 */

public class Client {
    private static Retrofit retrofit;
    private static final String URL_BASE = "https://crowdsrvcs-dot-behappy-188209.appspot.com/s/";

    public Client() {
    }

    public static ApiService getClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        return retrofit.create(ApiService.class);
    }
}
