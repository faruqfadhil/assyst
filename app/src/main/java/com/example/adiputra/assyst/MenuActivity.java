package com.example.adiputra.assyst;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

//    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TabLayout tab = (TabLayout) findViewById(R.id.tab1);
        tab.addTab(tab.newTab().setText("LIST"));
        tab.addTab(tab.newTab().setText("MAP"));
        tab.addTab(tab.newTab().setText("SETTING"));

        //The First Load
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.listFragment,new ListFragment());
        ft.commit();

/* frameLayout = (FrameLayout) findViewById(R.id.listFragment); */

        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.listFragment,new ListFragment());
                    ft.commit();
                }else if(tab.getPosition()==1){
                    android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.listFragment,new MapFragment());
                    ft.commit();
                }else if(tab.getPosition()==2){
                    android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.listFragment,new SettingFragment());
                    ft.commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}