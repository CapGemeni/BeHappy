package com.bbva.intranet.behappy.modules.eventos;

import android.os.Bundle;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentListaProximosBinding;

public class ListaProximosFragment extends Fragment implements View.OnClickListener {
private FragmentListaProximosBinding binding;

    public ListaProximosFragment() {
        }

      /*  @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)fin
        }

    private void setContentView(int activity_main) {
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista_proximos, null, false);
        setListeners();
        return binding.getRoot();

    }

private void setListeners() {
        binding.btnViernesBotanero.setOnClickListener(this);
        binding.btnCompartir.setOnClickListener(this);
        }

@Override
public void onClick(View view) {
    if (view.getId() == R.id.btn_viernes_botanero){
    }
    if (view.getId() == R.id.btn_viernes_botanero){
        Intent intent = new Intent(getActivity(), DetallesProximosEventosActivity.class);
        startActivity(intent);
    }

    if (view.getId() == R.id.btn_compartir){
    }
    if (view.getId() == R.id.btn_compartir){
        Intent intent = new Intent(getActivity(), DetallesProximosEventos2Activity.class);
        startActivity(intent);
    }
        }

}
