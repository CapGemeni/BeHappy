package com.bbva.intranet.behappy.modules.animometro;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.app.Application;
import com.bbva.intranet.behappy.components.BaseActivity;
import com.bbva.intranet.behappy.databinding.ActivityCuentanosMasBinding;
import com.bbva.intranet.behappy.models.Status;

public class CuentanosMasActivity extends BaseActivity implements View.OnClickListener {

    ActivityCuentanosMasBinding binding;
    Status status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cuentanos_mas);
        status = (Status) getIntent().getExtras().getSerializable(StatusFragment.ARG_STATUS);

        setSupportActionBar(binding.viewToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.menu_animometro);

        initViews();
        setListeners();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        binding.ivStatus.setImageResource(status.getImageResId());
        binding.tvStatus.setText(status.getTitle());
        binding.tvStatusDesc.setText(status.getDescriptionResId());
        binding.tvStatus.setTextColor(getResources().getColor(status.getBgColorResId()));
        binding.btnContinue.setBackgroundResource(status.getBtnResId());
    }

    private void setListeners() {
        binding.btnCuentanosMas.setOnClickListener(this);
        binding.btnTema1.setOnClickListener(this);
        binding.btnTema2.setOnClickListener(this);
        binding.btnTema3.setOnClickListener(this);
        binding.btnTema4.setOnClickListener(this);
        binding.btnTema5.setOnClickListener(this);
        binding.btnTema6.setOnClickListener(this);
        binding.btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_cuentanos_mas) {
            binding.containerCuentanosMas.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.tv_actualizar_estado){
            finish();
        } else if (view.getId() == R.id.btn_continue){
            ResultStatusDialog dFragment = ResultStatusDialog.newInstance(status, new ResultStatusDialog.ResultStatusDialogListener() {
                @Override
                public void onContinue() {
                    CuentanosMasActivity.this.startActivity(new Intent(Application.getInstance(), EstadisticaActivity.class));
                    CuentanosMasActivity.this.finish();
                }
            });
            FragmentManager fm = getSupportFragmentManager();
            dFragment.show(fm, "Dialog Fragment");
        } else {
            desactivarBotones(view);
        }

    }

    private void desactivarBotones(View view) {
        binding.btnTema1.setBackgroundResource(R.drawable.btn_stroke_disable);
        binding.btnTema2.setBackgroundResource(R.drawable.btn_stroke_disable);
        binding.btnTema3.setBackgroundResource(R.drawable.btn_stroke_disable);
        binding.btnTema4.setBackgroundResource(R.drawable.btn_stroke_disable);
        binding.btnTema5.setBackgroundResource(R.drawable.btn_stroke_disable);
        binding.btnTema6.setBackgroundResource(R.drawable.btn_stroke_disable);
        if (view.getId() == R.id.btn_tema1){
            binding.btnTema1.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
        if (view.getId() == R.id.btn_tema2){
            binding.btnTema2.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
        if (view.getId() == R.id.btn_tema3){
            binding.btnTema3.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
        if (view.getId() == R.id.btn_tema4){
            binding.btnTema4.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
        if (view.getId() == R.id.btn_tema5){
            binding.btnTema5.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
        if (view.getId() == R.id.btn_tema6){
            binding.btnTema6.setBackgroundResource(R.drawable.btn_stroke_pressed);
        }
    }
}
