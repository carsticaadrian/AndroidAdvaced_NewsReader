package com.carsticaadrian.newsreader;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.carsticaadrian.newsreader.ui.main.NewsListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new NewsListFragment())
                    .commitNow();
        }
    }
}