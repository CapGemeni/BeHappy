package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bbva.intranet.behappy.R;

public class ViernesBotanero2Activity extends AppCompatActivity {
    private View btn_listo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viernes_botanero2);

        btn_listo = findViewById(R.id.boton_listo);
        btn_listo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViernesBotanero2Activity.this, ListaProximosFragment.class);
                startActivity(intent);
            }
        });
    }
}
