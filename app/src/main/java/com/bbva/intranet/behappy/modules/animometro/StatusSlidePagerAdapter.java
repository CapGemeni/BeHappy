package com.bbva.intranet.behappy.modules.animometro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bbva.intranet.behappy.models.Status;

import java.util.List;

public class StatusSlidePagerAdapter extends FragmentStatePagerAdapter {
    List<Status>status;

    public StatusSlidePagerAdapter(FragmentManager fm, List<Status> status) {
        super(fm);
        this.status = status;
    }

    @Override
    public Fragment getItem(int position) {
        return StatusFragment.newInstance(position, status.get(position));
    }

    @Override
    public int getCount() {
        return status.size();
    }
}
