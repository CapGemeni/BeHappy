package com.bbva.intranet.behappy.modules.eventos;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityDetallesEventosProximosBinding;
import com.bbva.intranet.behappy.databinding.FragmentEventosProximosBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosProximosFragment extends Fragment implements View.OnClickListener {

    FragmentEventosProximosBinding binding;
    EventosProximosListener listener;

    public EventosProximosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_eventos_proximos,container,false);

        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.btnDetalleEvento.setOnClickListener(this);
        binding.btnDetalleEvent2.setOnClickListener(this);
        binding.btnDetalleEvento3.setOnClickListener(this);
    }

    public interface EventosProximosListener {
        public void onContinue();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_detalle_evento){
            Intent intent = new Intent(getActivity(), DetallesEventosProximosActivity.class);
            startActivity(intent);
        }if (view.getId() == R.id.btn_detalle_evento3){
            Intent intent = new Intent(getActivity(), DetallesEventosProximosActivity.class);
            startActivity(intent);
        }if (view.getId() == R.id.btn_detalle_event2){
            Intent intent = new Intent(getActivity(), DetallesEventosProximosActivity.class);
            startActivity(intent);
        }
    }
}
