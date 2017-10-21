package com.example.radva.szakdolgozat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FeedFragment feedFragment;
    private GameFragment gameFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feed:
                    if(feedFragment == null) {
                        feedFragment = new FeedFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, feedFragment).commit();
                    return true;
                case R.id.navigation_game:
                    if(gameFragment == null) {
                        gameFragment = new GameFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, gameFragment).commit();
                    return true;
                case  R.id.navigation_home:
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
