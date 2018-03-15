package com.bbva.intranet.behappy.modules.splash;

import android.app.Activity;


/**
 * Created by gesformexico on 22/02/18.
 */

public class SplashModel implements SplashView.Model {

    SplashView.Presenter presenter;

    public SplashModel(SplashView.Presenter presenter) {
        this.presenter = presenter;
    }

    public SplashModel() {
    }

    @Override
    public void callGetUser(SplashView splashView, Activity activity, String... params) {
        ServiceLogin serviceTest1 = new ServiceLogin(splashView, activity);
        serviceTest1.requestTokenAndExecute("params");

    }

}
