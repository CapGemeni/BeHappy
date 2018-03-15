package com.bbva.intranet.behappy.modules.eventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.bbva.intranet.behappy.R;

public class CheckInActivity extends AppCompatActivity {
    private View boton_qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);

        boton_qr = findViewById(R.id.btn_qr);
        boton_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CheckInActivity.this, ListaProximosFragment.class);
                startActivity(intent);
            }
        });
    }
}
