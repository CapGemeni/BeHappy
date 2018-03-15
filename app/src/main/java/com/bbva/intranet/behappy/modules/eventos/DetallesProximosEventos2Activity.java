package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.bbva.intranet.behappy.R;

public class DetallesProximosEventos2Activity extends AppCompatActivity {
    private View btn_listo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_proximos_eventos2);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        btn_listo = findViewById(R.id.boton_listo);
        btn_listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetallesProximosEventos2Activity.this, ListaProximosFragment.class);
                startActivity(intent);
            }
        });
    }
}
