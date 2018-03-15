package com.bbva.intranet.behappy.modules.general;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.components.BaseActivity;
import com.bbva.intranet.behappy.databinding.ActivityHomeBinding;
import com.bbva.intranet.behappy.modules.animometro.AnimometroFragment;
import com.bbva.intranet.behappy.modules.recompensas.RecompensasFragment;
import com.bbva.intranet.behappy.modules.eventos.EventosFragment;

public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ActivityHomeBinding binding;
    private ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setSupportActionBar(binding.containerRoot.containerToolbar.toolbar);
        getSupportActionBar().setTitle(R.string.menu_animometro);

        initViews();
        setListeners();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_root, AnimometroFragment.newInstance()).commit();

    }

    private void initViews() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.containerRoot.containerToolbar.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ivClose = (ImageView) binding.navView.getHeaderView(0).findViewById(R.id.btn_close);
    }

    private void setListeners() {
        binding.navView.setNavigationItemSelectedListener(this);
        ivClose.setOnClickListener(this);

        binding.containerRoot.containerHome.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                switch (item.getItemId()){
                    case R.id.action_animometro:
                        fragmentManager.beginTransaction().replace(R.id.content_root, AnimometroFragment.newInstance()).commit();
                        getSupportActionBar().setTitle(R.string.menu_animometro);
                        break;
                    case R.id.action_eventos:
                        fragmentManager.beginTransaction().replace(R.id.content_root, EventosFragment.newInstance()).commit();
                        getSupportActionBar().setTitle(R.string.menu_eventos);
                        break;
                    case R.id.action_recompensas:
                        fragmentManager.beginTransaction().replace(R.id.content_root, RecompensasFragment.newInstance()).commit();
                        getSupportActionBar().setTitle(R.string.menu_recompensas);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            closeMenu();
        } else {
            //TODO SHOW EXIT MESSAGE
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_notifications) {
            // Handle the camera action
        } else if (id == R.id.nav_goto_apps) {

        } else if (id == R.id.nav_onboarding) {

        } else if (id == R.id.nav_exit) {

        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_close){
            closeMenu();
        }
    }

    public void closeMenu(){
        binding.drawerLayout.closeDrawer(GravityCompat.START);
    }
}
