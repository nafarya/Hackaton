package com.example.dan.hackaton;

import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.dan.hackaton.lang.WordStorage;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WordStorage.init(getApplicationContext());
        getSupportActionBar().setTitle(getResources().getString(R.string.pick_game));



        setContentView(R.layout.main_fragment);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MainMenuFragment mainMenuFragment = new MainMenuFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainMenuFragment).commit();
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_menu:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
