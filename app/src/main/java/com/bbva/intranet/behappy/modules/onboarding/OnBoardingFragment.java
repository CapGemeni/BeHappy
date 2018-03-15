package com.bbva.intranet.behappy.modules.onboarding;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentOnBoardingBinding;
import com.bbva.intranet.behappy.modules.general.HomeActivity;

public class OnBoardingFragment extends Fragment implements View.OnClickListener {

    FragmentOnBoardingBinding binding;
    private static final String ARG_POSITION = "position";
    private int mPosition;

    public OnBoardingFragment() {
        // Required empty public constructor
    }

    public static OnBoardingFragment newInstance(int position) {
        OnBoardingFragment fragment = new OnBoardingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_on_boarding, container, false);
        init(mPosition);
        return binding.getRoot();
    }

    private void init(int position) {
        if (position == 0) {
            binding.ivOnboarding.setImageResource(R.mipmap.ic_onboarding1);
            binding.tvOnboardingTitle.setText(R.string.label_onboardingTitle1);
            binding.tvOnboardingMesage.setText(R.string.label_onboarding1);

        } else if (position == 1) {
            binding.ivOnboarding.setImageResource(R.mipmap.ic_onboarding2);
            binding.tvOnboardingTitle.setText(R.string.label_onboardingTitle2);
            binding.tvOnboardingMesage.setText(R.string.label_onboarding2);

        } else if (position == 2) {
            binding.ivOnboarding.setImageResource(R.mipmap.ic_onboarding3);
            binding.tvOnboardingTitle.setText(R.string.label_onboardingTitle3);
            binding.tvOnboardingMesage.setText(R.string.label_onboarding3);

        } else if (position == 3) {
            binding.ivOnboarding.setImageResource(R.mipmap.ic_onboarding4);
            binding.tvOnboardingTitle.setText(R.string.label_onboardingTitle4);
            binding.tvOnboardingMesage.setText(R.string.label_onboarding4);
            binding.containerOnboardingContinue.setVisibility(View.VISIBLE);
            binding.tvOnboardingContinue.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_onboarding_continue){
            startActivity(new Intent(getActivity(), HomeActivity.class));
            getActivity().finish();
        }
    }
}
