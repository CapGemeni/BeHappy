package com.bbva.intranet.behappy.modules.eventos;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentComentarEventoDialogBinding;
import com.bbva.intranet.behappy.modules.recompensas.PuntosTotalesFragment;

public class ComentarEventoDialog extends DialogFragment implements View.OnClickListener {


    FragmentComentarEventoDialogBinding binding;
    ComentarEventoDialogListener listener;
    PuntosTotalesFragment dfragment;





    public ComentarEventoDialog() {
        // Required empty public constructor
    }


    public static ComentarEventoDialog newInstance(ComentarEventoDialogListener listener) {
        ComentarEventoDialog fragment = new ComentarEventoDialog();
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_comentar_evento_dialog, container, false);
        setListener();
        return binding.getRoot();
    }




    private void setListener(){
        binding.btnCerrar.setOnClickListener(this);
        binding.btnEnviarComentario.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_cerrar){
            dismiss();
        }
        if(view.getId() == R.id.btn_enviar_comentario){
            EditText comentarios = (EditText)binding.editEnviarSugerencia;
            if (comentarios.getText().toString().isEmpty()){
                dismiss();
            }else{
                dfragment = PuntosTotalesFragment.newInstance(new PuntosTotalesFragment.PuntosTotalesListener() {
                    @Override
                    public void onContinue() {

                    }
                });

                    FragmentManager fm = getFragmentManager();
                    dfragment.show(fm, "Dialog Fragment");
                    dismiss();
            }

        }
    }


    public interface ComentarEventoDialogListener{
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
