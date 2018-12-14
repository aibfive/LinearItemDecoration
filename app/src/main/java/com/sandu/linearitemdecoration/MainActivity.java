package com.sandu.linearitemdecoration;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    String[] tabTexts = new String[]{"Horizonal Line", "Vertical Line"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        viewPager.setOffscreenPageLimit(tabTexts.length);
        viewPager.setAdapter(new FragmentAdapter<Fragment>(getSupportFragmentManager(), initFragment()));
        tabLayout.setupWithViewPager(viewPager);
        int length = tabTexts.length;

        for(int i = 0; i < length; i++){
            tabLayout.getTabAt(i).setText(tabTexts[i]);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private List<Fragment> initFragment(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HorizonalLineFragment());
        fragments.add(new VerticalLineFragment());
        return fragments;
    }

}
