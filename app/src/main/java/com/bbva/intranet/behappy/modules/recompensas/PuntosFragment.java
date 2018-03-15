package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentPuntosBinding;


public class PuntosFragment extends Fragment implements View.OnClickListener{

    FragmentPuntosBinding binding;
    public PuntosFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // View view = inflater.inflate(R.layout.fragment_puntos, container, false);
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_puntos, container,false);

        setListener();
        return binding.getRoot();
    }

    private void setListener(){
        //binding.btnPscArea.setOnClickListener(this);
        //binding.btnPscDireccion.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        /*if (view.getId() == R.id.btn_psc_direccion) {
            binding.contenedorList.setVisibility(View.GONE);
            binding.contenedorList2.setVisibility(View.VISIBLE);
            //binding.btnPscDireccion.setVisibility(View.GONE);
            //binding.btnPscArea.setVisibility(View.VISIBLE);
            //binding.textviewPsc.setText("Posiciones por dirección");

        }if (view.getId() == R.id.btn_psc_area){
          binding.contenedorList.setVisibility(View.VISIBLE);
          binding.contenedorList2.setVisibility(View.GONE);
          //binding.btnPscDireccion.setVisibility(View.VISIBLE);
          //binding.btnPscArea.setVisibility(View.GONE);
          //binding.textviewPsc.setText("Posiciones por aréa");
        }*/
    }



}
