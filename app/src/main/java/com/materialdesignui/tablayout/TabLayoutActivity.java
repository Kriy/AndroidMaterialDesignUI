package com.materialdesignui.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.materialdesignui.R;

public class TabLayoutActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        findViewById(R.id.btn_tab_01).setOnClickListener(this);
        findViewById(R.id.btn_tab_02).setOnClickListener(this);
        findViewById(R.id.btn_tab_03).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.btn_tab_01:
                intent.setClass(this, TabIndicatorActivity.class);
                break;
            case R.id.btn_tab_02:
                intent.setClass(this, TabIconActivity.class);
                break;
            case R.id.btn_tab_03:
                intent.setClass(this, TabIconVerActivity.class);
                break;
        }
        startActivity(intent);
    }
}
