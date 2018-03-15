package com.bbva.intranet.behappy.utils;

import com.bbva.intranet.behappy.models.User;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bbva.intranet.behappy.Environment.URL_SERVICE;

/**
 * Created by gesformexico on 22/02/18.
 */

public class Api {

    private static Retrofit retrofit = null;

    public static Retrofit getApi(final String token) {


        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        "Bearer " + token);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
        if (retrofit == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(User.class, new Deserializer());
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(URL_SERVICE)
                    .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))//crear una fatoria de Gson
                    .build();
        }
        return retrofit;
    }


}