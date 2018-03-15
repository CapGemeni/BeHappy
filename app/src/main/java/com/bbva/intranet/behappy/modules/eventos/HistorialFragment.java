package com.bbva.intranet.behappy.modules.eventos;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentHistorialBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistorialFragment extends Fragment implements View.OnClickListener {

    FragmentHistorialBinding binding;

    public HistorialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_historial, container, false);
        // Inflate the layout for this fragment

        return binding.getRoot();
    }




    @Override
    public void onClick(View view) {

    }


}
