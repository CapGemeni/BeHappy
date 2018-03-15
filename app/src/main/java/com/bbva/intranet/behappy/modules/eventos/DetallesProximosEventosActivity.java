package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import android.databinding.DataBindingUtil;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityDetallesProximosEventosBinding;

public class DetallesProximosEventosActivity extends AppCompatActivity implements View.OnClickListener  {

    ActivityDetallesProximosEventosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalles_proximos_eventos);
        setListener();
        setSupportActionBar(binding.viewToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detalles");
    }

    private void setListener(){
        binding.botonCheckin.setOnClickListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public interface EventosProximosListener {
        public void onContinue();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.boton_chekin){
            Intent intent = new Intent(this, CheckInActivity.class);
            startActivity(intent);
        }
    }


}
