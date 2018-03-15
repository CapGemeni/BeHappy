package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentPuntosTotales2Binding;
import com.bbva.intranet.behappy.modules.eventos.DetallesEventosProximosActivity;


public class PuntosTotales2Fragment extends DialogFragment implements View.OnClickListener {

    FragmentPuntosTotales2Binding binding;
    PuntosTotales2Listener listener;
    public PuntosTotales2Fragment() {
        // Required empty public constructor
    }

    public static PuntosTotales2Fragment newInstance(PuntosTotales2Listener listener) {
        PuntosTotales2Fragment fragment = new PuntosTotales2Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setStyle(STYLE_NO_TITLE, R.style.Theme_Dialog_Transparents);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_puntos_totales2,container,false);
        setListener();
        return binding.getRoot();
    }

    private void  setListener(){
        binding.botonVerMisLogros.setOnClickListener(this);
        binding.btnClose.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btn_close){
            dismiss();
        }
        if (view.getId() == R.id.boton_ver_mis_logros){
            Intent intent = new Intent(getActivity(), DetallesEventosProximosActivity.class);
            startActivity(intent);
            dismiss();
        }
    }

    public interface PuntosTotales2Listener{
        public void onContinue();
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

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }

}
