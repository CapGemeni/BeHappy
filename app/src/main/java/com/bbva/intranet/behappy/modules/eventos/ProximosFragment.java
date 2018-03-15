package com.bbva.intranet.behappy.modules.eventos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProximosFragment extends Fragment {


    public ProximosFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_proximos, container, false);
    }

}
