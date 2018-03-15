package com.bbva.intranet.behappy.modules.recompensas;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;

import com.bbva.intranet.behappy.databinding.FragmentMisBadgetsBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisBadgetsFragment extends Fragment implements View.OnClickListener{

    FragmentMisBadgetsBinding binding;
    public MisBadgetsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mis_badgets, container, false);
        //View view = inflater.inflate(R.layout.fragment_mis_badgets, container, false);
        setListener();
        return binding.getRoot();
    }

    private void setListener(){
        binding.toggleBadgets.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (binding.toggleBadgets.isChecked()){
            binding.pts1.setText("12");
        }else {
            binding.pts1.setText("7");
        }
    }
}


