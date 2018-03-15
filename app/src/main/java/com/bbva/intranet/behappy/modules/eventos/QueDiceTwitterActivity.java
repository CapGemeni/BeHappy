package com.bbva.intranet.behappy.modules.eventos;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.ActivityQueDiceTwitterBinding;

public class QueDiceTwitterActivity extends AppCompatActivity {

    ActivityQueDiceTwitterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_que_dice_twitter);
        //setContentView(R.layout.activity_que_dice_twitter);
        setSupportActionBar(binding.viewToolbar.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Qué dicen en Twitter");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
