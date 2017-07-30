package com.materialdesignui.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.materialdesignui.R;

/**
 * Created by DF on 2017/7/30.
 */

public class TabIconVerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_icon_ver);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tb);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);

        TabVerPagerAdapter tabVerPagerAdapter = new TabVerPagerAdapter(this);
        viewPager.setAdapter(tabVerPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabVerPagerAdapter.getTabView(i));
            }
        }
        viewPager.setCurrentItem(1);
    }
}
