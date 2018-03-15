package com.bbva.intranet.behappy.modules.animometro;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.models.Status;
import java.util.ArrayList;
import java.util.List;

class AnimometroPresenter implements AnimometroInteractor.CallbackService {
    private AnimometroView animometroView;
    private AnimometroInteractor interactor;

    AnimometroPresenter(AnimometroView animometroView) {
        this.animometroView = animometroView;
    }

    void onCreate(){
        interactor = new AnimometroInteractor(this);
        getStatus();
    }


    void onDestroy() {
        animometroView = null;
    }

    private void getStatus(){
        animometroView.showProgress();
        interactor.getAnimos();
    }

    @Override
    public void animos(List<Status> statusList) {
        animometroView.hideProgress();
        animometroView.createStatus(statusList);
    }

    @Override
    public void notResponse() {
        animometroView.hideProgress();

        final List<Status> status = new ArrayList<>();

        Status status1 = new Status();
        status1.setTitle("Super Feliz");
        status1.setImageResId(R.mipmap.ic_animometro_super_feliz);
        status1.setBtnResId(R.drawable.btn_solid_yellow);
        status1.setHeaderResIdOff(R.mipmap.ic_superfeliz_off);
        status1.setHeaderResIdOn(R.mipmap.ic_superfeliz_on);
        status1.setBgColorResId(R.color.yellow);
        status1.setTitleResId(R.string.label_animometro_super_feliz);
        status1.setDescriptionResId(R.string.label_animometro_super_feliz_desc);

        Status status2 = new Status();
        status2.setTitle("Bien");
        status2.setImageResId(R.mipmap.ic_animometro_bien);
        status2.setBtnResId(R.drawable.btn_solid_pink);
        status2.setHeaderResIdOff(R.mipmap.ic_bien_off);
        status2.setHeaderResIdOn(R.mipmap.ic_bien_on);
        status2.setBgColorResId(R.color.pink);
        status2.setTitleResId(R.string.label_animometro_bien);
        status2.setDescriptionResId(R.string.label_animometro_bien_desc);

        Status status3 = new Status();
        status3.setTitle("Meh");
        status3.setImageResId(R.mipmap.ic_animometro_meh);
        status3.setBtnResId(R.drawable.btn_solid_aqua);
        status3.setHeaderResIdOff(R.mipmap.ic_meh_off);
        status3.setHeaderResIdOn(R.mipmap.ic_meh_on);
        status3.setBgColorResId(R.color.aqua);
        status3.setTitleResId(R.string.label_animometro_meh);
        status3.setDescriptionResId(R.string.label_animometro_meh_desc);

        Status status4 = new Status();
        status4.setTitle("Enojado");
        status4.setImageResId(R.mipmap.ic_animometro_enojado);
        status4.setBtnResId(R.drawable.btn_solid_red);
        status4.setHeaderResIdOff(R.mipmap.ic_enojado_off);
        status4.setHeaderResIdOn(R.mipmap.ic_enojado_on);
        status4.setBgColorResId(R.color.red);
        status4.setTitleResId(R.string.label_animometro_enojado);
        status4.setDescriptionResId(R.string.label_animometro_enojado_desc);

        Status status5 = new Status();
        status5.setTitle("Triste");
        status5.setImageResId(R.mipmap.ic_animometro_triste);
        status5.setBtnResId(R.drawable.btn_solid_blue);
        status5.setHeaderResIdOff(R.mipmap.ic_triste_off);
        status5.setHeaderResIdOn(R.mipmap.ic_triste_on);
        status5.setBgColorResId(R.color.blue);
        status5.setTitleResId(R.string.label_animometro_triste);
        status5.setDescriptionResId(R.string.label_animometro_triste_desc);

        status.add(status3);
        status.add(status4);
        status.add(status1);
        status.add(status2);
        status.add(status5);

        animometroView.createStatus(status);
    }

    void fragmentDetached(Boolean aBoolean){
        interactor.fragmentDetached(aBoolean);
    }
}
