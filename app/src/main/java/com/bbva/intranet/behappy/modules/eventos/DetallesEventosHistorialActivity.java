package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityDetallesEventosHistorialBinding;

public class DetallesEventosHistorialActivity extends AppCompatActivity implements View.OnClickListener{

    private ValorarEventoDialog dFragment;
    ActivityDetallesEventosHistorialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_detalles__eventos__historial);
        setListener();
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detalles__eventos__historial);



    }

    private void setListener(){

    }

    @Override
    public void onClick(View view) {


    }
}
