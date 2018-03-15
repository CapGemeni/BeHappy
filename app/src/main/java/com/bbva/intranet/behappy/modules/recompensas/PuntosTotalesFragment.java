package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.databinding.DataBindingUtil;
import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentPuntosTotalesBinding;
import com.bbva.intranet.behappy.modules.animometro.StatusFragment;

public class PuntosTotalesFragment extends Fragment implements View.OnClickListener {
    private FragmentPuntosTotalesBinding binding;
    private int status;
    public PuntosTotalesFragment() {

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
            Intent intent = new Intent(getActivity(), LogrosFragment.class);
            intent.putExtra(StatusFragment.ARG_STATUS, status);
            startActivity(intent);
            dismiss();
        }
    }

    private void dismiss() {
    }

}
