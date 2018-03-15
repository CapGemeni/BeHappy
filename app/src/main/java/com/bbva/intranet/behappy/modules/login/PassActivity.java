package com.bbva.intranet.behappy.modules.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.components.BaseActivity;
import com.bbva.intranet.behappy.databinding.ActivityPassBinding;
import com.bbva.intranet.behappy.modules.general.HomeActivity;

public class PassActivity extends BaseActivity implements View.OnClickListener {

    ActivityPassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pass);
        initViews();
        setListeners();
    }

    private void initViews() {

    }

    private void setListeners() {
        binding.btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_ingresar){
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }
}