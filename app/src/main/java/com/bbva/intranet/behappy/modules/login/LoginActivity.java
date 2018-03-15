package com.bbva.intranet.behappy.modules.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.components.BaseActivity;
import com.bbva.intranet.behappy.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        initViews();
        setListiners();
    }

    private void setListiners() {
        binding.btnContinue.setOnClickListener(this);
    }

    private void initViews() {
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_continue){
            startActivity(new Intent(this, PassActivity.class));
            finish();
        }
    }
}
