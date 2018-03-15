package com.bbva.intranet.behappy.modules.animometro;


import android.os.AsyncTask;
import android.util.Log;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.app.Config;
import com.bbva.intranet.behappy.models.AnimoResponse;
import com.bbva.intranet.behappy.models.Status;
import com.bbva.intranet.behappy.utils.ApiService;
import com.bbva.intranet.behappy.utils.Client;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DANIEGAR on 09/03/2018.
 */

public class AnimometroInteractor {
    private ApiService service;
    private CallbackService callbackService;
    private ServiceTask serviceTask;
    private Boolean cancel = false;

    public AnimometroInteractor(CallbackService callbackService) {
        this.service = Client.getClient();
        this.callbackService = callbackService;
    }

    public void getAnimos() {
        serviceTask = new ServiceTask();
        serviceTask.execute();
    }

    interface CallbackService {
        void animos(List<Status> list);
        void notResponse();
    }

    private class ServiceTask extends AsyncTask<Void, Void, AnimoResponse> {

        @Override
        protected AnimoResponse doInBackground(Void... voids) {
            Call<AnimoResponse> call = service.getAnimos();
            call.enqueue(new Callback<AnimoResponse>() {
                @Override
                public void onResponse(Call<AnimoResponse> call, Response<AnimoResponse> response) {
                    Log.i(Config.TAG, "Response: " + response.body().toString());
                    if (response.body() != null){
                        final List<com.bbva.intranet.behappy.models.Status > status = new ArrayList<>();

                        for (int i = 0; i < response.body().getData().size(); i++){
                            com.bbva.intranet.behappy.models.Status status1 = new com.bbva.intranet.behappy.models.Status();
                            status1.setTitle(response.body().getData().get(i).getDescripcion());

                            switch (response.body().getData().get(i).getDescripcion()){

                                case "Super Feliz":
                                    status1.setImage(response.body().getData().get(i).getEmoji());
                                    status1.setImageResId(R.mipmap.ic_animometro_super_feliz);
                                    status1.setBtnResId(R.drawable.btn_solid_yellow);
                                    status1.setHeaderResIdOff(R.mipmap.ic_superfeliz_off);
                                    status1.setHeaderResIdOn(R.mipmap.ic_superfeliz_on);
                                    status1.setBgColorResId(R.color.yellow);
                                    status1.setTitleResId(R.string.label_animometro_super_feliz);
                                    status1.setDescriptionResId(R.string.label_animometro_super_feliz_desc);
                                    break;

                                case "Bien":
                                    status1.setImage(response.body().getData().get(i).getEmoji());
                                    status1.setImageResId(R.mipmap.ic_animometro_bien);
                                    status1.setBtnResId(R.drawable.btn_solid_pink);
                                    status1.setHeaderResIdOff(R.mipmap.ic_bien_off);
                                    status1.setHeaderResIdOn(R.mipmap.ic_bien_on);
                                    status1.setBgColorResId(R.color.pink);
                                    status1.setTitleResId(R.string.label_animometro_bien);
                                    status1.setDescriptionResId(R.string.label_animometro_bien_desc);
                                    break;

                                case "Meh":
                                    status1.setImage(response.body().getData().get(i).getEmoji());
                                    status1.setImageResId(R.mipmap.ic_animometro_meh);
                                    status1.setBtnResId(R.drawable.btn_solid_aqua);
                                    status1.setHeaderResIdOff(R.mipmap.ic_meh_off);
                                    status1.setHeaderResIdOn(R.mipmap.ic_meh_on);
                                    status1.setBgColorResId(R.color.aqua);
                                    status1.setTitleResId(R.string.label_animometro_meh);
                                    status1.setDescriptionResId(R.string.label_animometro_meh_desc);
                                    break;

                                case "Enojado":
                                    status1.setImage(response.body().getData().get(i).getEmoji());
                                    status1.setImageResId(R.mipmap.ic_animometro_enojado);
                                    status1.setBtnResId(R.drawable.btn_solid_red);
                                    status1.setHeaderResIdOff(R.mipmap.ic_enojado_off);
                                    status1.setHeaderResIdOn(R.mipmap.ic_enojado_on);
                                    status1.setBgColorResId(R.color.red);
                                    status1.setTitleResId(R.string.label_animometro_enojado);
                                    status1.setDescriptionResId(R.string.label_animometro_enojado_desc);
                                    break;

                                case "Triste":
                                    status1.setImage(response.body().getData().get(i).getEmoji());
                                    status1.setTitle("Triste");
                                    status1.setImageResId(R.mipmap.ic_animometro_triste);
                                    status1.setBtnResId(R.drawable.btn_solid_blue);
                                    status1.setHeaderResIdOff(R.mipmap.ic_triste_off);
                                    status1.setHeaderResIdOn(R.mipmap.ic_triste_on);
                                    status1.setBgColorResId(R.color.blue);
                                    status1.setTitleResId(R.string.label_animometro_triste);
                                    status1.setDescriptionResId(R.string.label_animometro_triste_desc);

                                default:
                                    break;

                            }
                            status.add(status1);
                        }
                        callbackService.animos(status);
                    }
                }

                @Override
                public void onFailure(Call<AnimoResponse> call, Throwable t) {
                    Log.i(Config.TAG, "Error: " + t.getMessage());
                    callbackService.notResponse();
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(AnimoResponse response) {
            super.onPostExecute(response);
        }
    }

    void fragmentDetached(Boolean aBoolean) {
        cancel = aBoolean;
        if (serviceTask != null && cancel) {
            serviceTask.cancel(true);
        }
    }
}
