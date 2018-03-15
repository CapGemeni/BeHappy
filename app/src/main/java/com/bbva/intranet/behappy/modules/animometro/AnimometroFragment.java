package com.bbva.intranet.behappy.modules.animometro;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.app.Config;
import com.bbva.intranet.behappy.databinding.FragmentAnimometroBinding;
import com.bbva.intranet.behappy.models.Status;

import java.util.List;

public class AnimometroFragment extends Fragment implements AnimometroView, ViewPager.OnPageChangeListener {

    FragmentAnimometroBinding binding;
    AnimometroPresenter presenter;
    private StatusHeaderAdapter adapterHeader;

    public AnimometroFragment() {
        // Required empty public constructor
    }

    public static AnimometroFragment newInstance() {
        AnimometroFragment fragment = new AnimometroFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AnimometroPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_animometro, container, false);
        return binding.getRoot();
    }

    @Override public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onCreate();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i(Config.TAG, "on scrolled " + position + " offset " + positionOffset + " pixels " + positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        binding.scrollViewHeader.setCenter(position, adapterHeader);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i(Config.TAG, "on scroll state changed " + state);
    }

    @Override
    public void showProgress() {
        binding.progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progress.setVisibility(View.GONE);
    }

    @Override
    public void createStatus(List<Status> status) {
        StatusSlidePagerAdapter adapter = new StatusSlidePagerAdapter(getActivity().getSupportFragmentManager(), status);
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.addOnPageChangeListener(this);

        adapterHeader = new StatusHeaderAdapter(getContext(), R.layout.view_animometro_header, status);
        binding.scrollViewHeader.setAdapter(adapterHeader, status);

        binding.scrollViewHeader.setCenter(0, adapterHeader);

        binding.scrollViewHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(Config.TAG, "click en scroll");

            }
        });

    }

    @Override
    public void navigateToStatistics() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.fragmentDetached(true);
    }
}
