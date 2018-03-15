package com.bbva.intranet.behappy.utils;

import com.bbva.intranet.behappy.models.AnimoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DANIEGAR on 09/03/2018.
 */

public interface ApiService {
    @GET("animo/lista")
    Call<AnimoResponse> getAnimos();
}
