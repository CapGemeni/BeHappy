package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bbva.intranet.behappy.R;

public class ViernesBotaneroActivity extends AppCompatActivity {
    private View boton_chek_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viernes_botanero);

        boton_chek_in = findViewById(R.id.boton_chekin);
        boton_chek_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViernesBotaneroActivity.this, CheckInActivity.class);
                startActivity(intent);
            }
        });
    }
}
