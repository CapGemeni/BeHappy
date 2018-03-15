package com.bbva.intranet.behappy.components;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected ChangeFragmentRequester requestChangeFragment;


    protected void setChangeFragmentRequester(ChangeFragmentRequester requester) {
        this.requestChangeFragment = requester;
    }

    public interface ChangeFragmentRequester {
        void onRequestChangeFragment(Fragment fragment, boolean saveInStack, @Nullable String tag);
    }
}
