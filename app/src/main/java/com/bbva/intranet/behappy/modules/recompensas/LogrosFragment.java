package com.bbva.intranet.behappy.modules.recompensas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentLogrosBinding;


public class LogrosFragment extends Fragment implements View.OnClickListener {
    private FragmentLogrosBinding binding;

    public LogrosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_logros, null, false);
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.btnDiamanteAqua.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_diamante_aqua) {
        }
        if (view.getId() == R.id.btn_diamante_aqua) {
            Intent intent = new Intent(getActivity(), LogrosFragment.class);
            startActivity(intent);
        }
    }
}
