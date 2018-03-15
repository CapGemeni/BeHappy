package com.bbva.intranet.behappy.modules.splash;


import android.app.Activity;
import android.os.Handler;

import com.bbva.intranet.behappy.app.Config;
import com.bbva.intranet.behappy.utils.ResultService;

public class SplashPresenter implements SplashView.Presenter {
    private final SplashView splashView;
    private SplashView.Model splashViewModel;
    private String name;

    public SplashPresenter(SplashView splashView) {
        this.splashView = splashView;

//        splashViewModel = new SplashModel(this);

        initTimer();
    }

    public SplashPresenter(SplashView splashView, String name) {
        this.splashView = splashView;
        splashViewModel = new SplashModel(this);
        this.name = name;
//        initTimer();
    }

    private void initTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                splashView.navigateToOnboarding();
            }
        }, Config.SPLASH_DURATION);
    }

    @Override
    public void callGetUser(SplashView splashView, Activity activity, String... params) {
         splashViewModel.callGetUser(splashView, activity, params);
    }
}
