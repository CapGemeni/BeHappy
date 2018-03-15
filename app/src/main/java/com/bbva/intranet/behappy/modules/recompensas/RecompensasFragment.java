package com.bbva.intranet.behappy.modules.recompensas;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentRecompensasBinding;
import com.bbva.intranet.behappy.models.PageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecompensasFragment extends Fragment {

    private FragmentRecompensasBinding binding;

    public RecompensasFragment() {
        // Required empty public constructor
    }

    public static RecompensasFragment newInstance() {
        RecompensasFragment fragment = new RecompensasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recompensas, container, false);

        TabLayout tabLayout = (TabLayout) binding.tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText("BADGETS"));
        tabLayout.addTab(tabLayout.newTab().setText("DISTINCIONES"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) binding.viewPager;
        PageAdapter pagerAdapter = new PageAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return binding.getRoot();
    }

}
