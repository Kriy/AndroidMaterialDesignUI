package com.materialdesignui.swiperefreshlayout;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView       mRv;
    private SwipeRefreshLayout mSp;

    private List<String>    mList;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);

        initView();
    }

    private void initView() {
        mSp = (SwipeRefreshLayout) findViewById(R.id.sp);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new RecyclerAdapter(this);
        mRv.setAdapter(mAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.btn_size).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_swipe_color).setOnClickListener(this);
        findViewById(R.id.btn_distance).setOnClickListener(this);

        mSp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSp.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSp.setRefreshing(false);
                        initData();
                    }
                }, 5000);
            }
        });
        init();
    }

    private void init() {
        mSp.setRefreshing(true);
        mSp.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSp.setRefreshing(false);
                initData();
            }
        }, 3000);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add(String.format("这是第%d个item", i));
        }
        mAdapter.reFreshData(mList);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_size) {

        } else if (id == R.id.btn_color) {

        } else if (id == R.id.btn_swipe_color) {

        } else if (id == R.id.btn_distance) {

        }
    }
}
