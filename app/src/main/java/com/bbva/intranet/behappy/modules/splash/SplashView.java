package com.bbva.intranet.behappy.modules.splash;

import android.app.Activity;

import com.bbva.intranet.behappy.utils.ResultService;

public interface SplashView {
    void navigateToLogin();

    void navigateToOnboarding();

//   SplashView getView(Activity activity);

    interface Model {
        void callGetUser( SplashView splashView,Activity activity, String... params);
    }

    interface Presenter {
        void callGetUser( SplashView splashView, Activity activity, String... params);
    }
}
