package com.bbva.intranet.behappy.modules.recompensas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DistincionesFragment extends Fragment {


    public DistincionesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_distinciones, container, false);
    }

}
