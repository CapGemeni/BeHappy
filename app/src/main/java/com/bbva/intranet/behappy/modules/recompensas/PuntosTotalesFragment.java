package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.databinding.DataBindingUtil;
import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentPuntosTotalesBinding;
import com.bbva.intranet.behappy.modules.animometro.StatusFragment;

public class PuntosTotalesFragment extends DialogFragment implements View.OnClickListener {


    private FragmentPuntosTotalesBinding binding;
    private int status;
    PuntosTotalesListener listener;
    PuntosTotales2Fragment dfragment;

    public PuntosTotalesFragment() {
    //constructos vacio
    }


    public static PuntosTotalesFragment newInstance(PuntosTotalesListener puntosTotalesListener) {
        PuntosTotalesFragment frag = new PuntosTotalesFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setStyle(STYLE_NO_TITLE, R.style.Theme_Dialog_Transparents);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_puntos_totales, null, false);
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.btnClose.setOnClickListener(this);
        binding.botonVerMisLogros.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close){
            dismiss();
        }
        if (v.getId() == R.id.boton_ver_mis_logros){
            dfragment = PuntosTotales2Fragment.newInstance(new PuntosTotales2Fragment.PuntosTotales2Listener() {
                @Override
                public void onContinue() {

                }
            });
                FragmentManager fm = getFragmentManager();
                dfragment.show(fm, "Dialog Fragment");
                dismiss();
        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
    }


    @Override
    public int show(FragmentTransaction transaction, String tag) {
        transaction.add(this, tag);
        return transaction.commitAllowingStateLoss();
    }

    public interface PuntosTotalesListener{
        public void onContinue();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

}
