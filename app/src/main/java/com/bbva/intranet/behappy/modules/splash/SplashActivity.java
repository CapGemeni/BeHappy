package com.bbva.intranet.behappy.modules.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bbva.intranet.behappy.Environment;
import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.modules.onboarding.OnboardingActivity;
import com.bbva.login.OAuthManager;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private static final String TAG = "BeHappy";
    private SplashPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        OAuthManager.getInstance().Configure(Environment.Environment);

        presenter = new SplashPresenter(SplashActivity.this, "login");
        presenter.callGetUser(SplashActivity.this, SplashActivity.this, "params");
    }

    @Override
    public void navigateToLogin() {
        //startActivity(new Intent(this, ));
    }

    @Override
    public void navigateToOnboarding() {

        startActivity(new Intent(this, OnboardingActivity.class));
        finish();
    }

    public static void LogoutUser(Context context) {
        // Logout
        OAuthManager.getInstance().Logout(context, new OAuthManager.LogoutListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "Logout success.");
            }

            @Override
            public void onError(int errorCode, String errorMessage) {
                Log.e(TAG, errorMessage);
            }
        });
    }


}
