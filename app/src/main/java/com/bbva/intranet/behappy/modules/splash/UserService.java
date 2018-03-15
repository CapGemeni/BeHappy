package com.bbva.intranet.behappy.modules.splash;

import com.bbva.intranet.behappy.models.User;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by gesformexico on 22/02/18.
 */

public interface UserService {

    @POST("/gprofile/s/v2/session")
    Call<User> getUser();

}