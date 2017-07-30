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

public class TabIconActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mVp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_icon);

        mTabLayout = (TabLayout) findViewById(R.id.tb);
        mVp = (ViewPager) findViewById(R.id.vp);

        TabPagerAdapter tabPageAdapter = new TabPagerAdapter(this);
        mVp.setAdapter(tabPageAdapter);
        mTabLayout.setupWithViewPager(mVp);
    }
}
