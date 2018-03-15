package com.bbva.intranet.behappy.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bbva.intranet.behappy.modules.recompensas.DistincionesFragment;
import com.bbva.intranet.behappy.modules.recompensas.LogrosFragment;
import com.bbva.intranet.behappy.modules.recompensas.PuntosFragment;

/**
 * Created by Martin Vega on 09/03/2018.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private int numberOfTaps;

    public PageAdapter(FragmentManager fm, int numberOfTaps) {
        super(fm);
        this.numberOfTaps = numberOfTaps;

    }

    @Override
    public Fragment getItem(int position) {
        switch ( position){
            case 0 :
                return new PuntosFragment();
            case 1:
                return new DistincionesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTaps;
    }
}
