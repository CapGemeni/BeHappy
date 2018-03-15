package com.bbva.intranet.behappy.modules.eventos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityDetallesEventosProximosBinding;

public class DetallesEventosProximosActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityDetallesEventosProximosBinding binding;
    private DialogValorarEvento dFragment;
    private ComentarEventoDialog fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detalles_eventos_proximos);
       setListener();

        setSupportActionBar(binding.viewToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detalle");
    }

    private void setListener(){
        binding.btnCalifica.setOnClickListener(this);
        binding.btnComenta.setOnClickListener(this);
        binding.textEnlacesTwitter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.text_enlaces_twitter){
            Intent intent = new Intent(this, QueDiceTwitterActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btn_comenta) {
            fragment = ComentarEventoDialog.newInstance(new ComentarEventoDialog.ComentarEventoDialogListener() {
                @Override
                public void onContinue() {

                }
            });

            FragmentManager fm = getSupportFragmentManager();
            fragment.show(fm, "Dialog Fragment");

        }

        if(view.getId() == R.id.btn_califica){
            dFragment = DialogValorarEvento.newInstance(new DialogValorarEvento.DialogValorarEventoListener() {
                @Override
                public void onContinue() {

                }
            });

            FragmentManager fm = getSupportFragmentManager();
            dFragment.show(fm, "Dialog Fragmen");

        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
