package com.bbva.intranet.behappy.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bbva.intranet.behappy.modules.eventos.HistorialEventosFragment;
import com.bbva.intranet.behappy.modules.eventos.HistorialFragment;
import com.bbva.intranet.behappy.modules.eventos.ProximosFragment;


/**
 * Created by Martin Vega on 09/03/2018.
 */

public class EventosAdapter extends FragmentStatePagerAdapter {

    private int numberOfTaps;

    public EventosAdapter(FragmentManager fm, int numberOfTaps) {
        super(fm);
        this.numberOfTaps = numberOfTaps;

    }

    @Override
    public Fragment getItem(int position) {
        switch ( position){
            case 0 :
                return new ProximosFragment();
            case 1:
                return new HistorialFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTaps;
    }
}
