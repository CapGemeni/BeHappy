package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentValorarEventoDialogBinding;



public class ValorarEventoDialog extends DialogFragment implements View.OnClickListener {


    private ValorarEventoDialogListener listener;
    private FragmentValorarEventoDialogBinding binding;

    public ValorarEventoDialog() {
        // Required empty public constructor
    }


    public static ValorarEventoDialog newInstance(ValorarEventoDialogListener listener) {
        ValorarEventoDialog frag = new ValorarEventoDialog();
        Bundle args = new Bundle();
        frag.listener = listener;
        frag.setArguments(args);
        return frag;
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_valorar_evento_dialog, container, false);
        setListeners();
        return binding.getRoot();
    }

    private void setListeners(){
        binding.botonCerrar.setOnClickListener(this);
        binding.rating.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if ( view.getId() == R.id.boton_cerrar) {
            dismiss();
        }
        if (view.getId() == R.id.rating) {
            dismiss();
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null) {
            return;
        }
        getDialog().getWindow().setWindowAnimations(R.style.dialog_animation_enter_top_to_bottom);
    }

    public void dismiss() {
        super.dismiss();
    }


    public interface ValorarEventoDialogListener{
        public void onContinue();
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
