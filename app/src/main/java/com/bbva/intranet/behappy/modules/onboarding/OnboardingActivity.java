package com.bbva.intranet.behappy.modules.onboarding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityOnboardingBinding;

public class OnboardingActivity extends AppCompatActivity {

    ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding);

        ScreenSlidePagerAdapter adapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.indicator.setViewPager(binding.viewpager);
    }

    @Override
    public void onBackPressed() {
        if (binding.viewpager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            binding.viewpager.setCurrentItem(binding.viewpager.getCurrentItem() - 1);
        }
    }


}
