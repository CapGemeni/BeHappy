package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentPersonalRecompensasBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalRecompensasFragment extends Fragment implements View.OnClickListener {

    private FragmentPersonalRecompensasBinding binding;


    public PersonalRecompensasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_recompensas,container,false);
        setListener();
        return binding.getRoot();
    }

    private void setListener(){
        binding.btnDetalle.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_detalle){
            Intent intent = new Intent(getActivity(), DetallesActivity.class);
            startActivity(intent);
        }
    }

}
