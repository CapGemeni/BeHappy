package com.bbva.intranet.behappy.modules.eventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.bbva.intranet.behappy.R;

public class CalendarioAgregoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario_agrego);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    }
}
