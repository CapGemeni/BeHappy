package com.bbva.intranet.behappy.modules.splash;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.bbva.intranet.behappy.models.User;
import com.bbva.intranet.behappy.utils.Api;
import com.bbva.intranet.behappy.utils.ResultService;
import com.bbva.intranet.behappy.utils.Utils;
import com.bbva.login.OAuthManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by gesformexico on 22/02/18.
 */

public class ServiceLogin extends AsyncTask<String, Void, ResultService> {
    String token1;
    Activity activity;
    SplashView view;
    public SplashPresenter presenter;

    public ServiceLogin() {
    }

    public String getToken1() {
        return token1;
    }

    public void setToken1(String token1) {
        this.token1 = token1;
    }

    public ServiceLogin(SplashView splashView, Activity activity) {
        this.activity = activity;
        this.view = splashView;
    }


    public String requestTokenAndExecute(final String... params) {
        // Obtener o refrescar token antes de cada invocación a un servicio
        OAuthManager.getInstance().requestAccessToken(activity, new OAuthManager.TokenRequestListener() {
            @Override
            public void onRequestTokenSucces(String token) {
                // Lanzar petición tras obtener el token
                token1 = token;
                execute(params);

                // mCleanCredentials.setEnabled(true);
            }

            @Override
            public void onRequestTokenError(int errorCode, String errorMessage) {
                // Manejar error
                Log.d(TAG, "ERROR: " + errorMessage);
                Utils.ManageError(errorCode, errorMessage, activity);
            }
        });
        return token1;
    }

    @Override
    protected ResultService doInBackground(final String... params) {
//        return CallServiceTest1(token, params);
        setToken1(token1);
        return callGetUserInfo(token1, params);
        // ejecutar petición en Background
    }

    @Override
    protected void onPostExecute(final ResultService result) {
        if (result.Exception == null) {
            Log.d(TAG, "Result: " + result.Response);
            presenter = new SplashPresenter(view);

            //   mTextView.setText(result.Response);
        } else {
            Toast.makeText(activity, "ERROR: " + result.Exception.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


    public ResultService callGetUserInfo(String token, String... params) {
        final ResultService resultTest = new ResultService();
        Retrofit retrofit = Api.getApi(token);
        //Implemente esa interface
        UserService service = retrofit.create(UserService.class);
        Call<User> userCall = service.getUser();
        resultTest.setToken(token);
        //Realizar una llamada asincrona
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {
                User user = response.body();
                if (user != null) {
                    resultTest.setData(user);
                    resultTest.setResponse("Usuario Obtenido satisfactoriamente");

                } else {
                    resultTest.setResponse("No hay datos para mostrar");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                resultTest.Exception = (Exception) t;
//                    Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show();
            }
        });
        return resultTest;
    }


}