package com.materialdesignui.swiperefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int DELAYED_TIME = 3000;

    private SwipeRefreshLayout mSp;

    private RecyclerAdapter mAdapter;
    private boolean mIsChangeSize;
    private boolean mIsChangeColor;
    private boolean mIsChangeSwipeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);

        initView();
    }

    private void initView() {
        mSp = (SwipeRefreshLayout) findViewById(R.id.sp);
        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv);
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
                }, DELAYED_TIME);
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
        }, 2000);
    }

    private void initData() {
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add(String.format("这是第%d个item", i));
        }
        Toast.makeText(this, "加载成功...", Toast.LENGTH_SHORT).show();
        mAdapter.reFreshData(mList);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_size) {
            changeSize();
        } else if (id == R.id.btn_color) {
            changeColor();
        } else if (id == R.id.btn_swipe_color) {
            changeSwipeColor();
        } else if (id == R.id.btn_distance) {
            changeDistance();
        }
    }

    private void changeSize() {
        //此处设置加载圈的大小只有两种DEFAULT(1)和LARGE（0）
        mSp.setSize(mIsChangeSize ? 1 : 0);
        mIsChangeSize = !mIsChangeSize;
    }

    private void changeColor() {
        //此处设置加载圈的背景颜色,两种方法,如果设置透明就完全看不到
        //mSp.setProgressBackgroundColorSchemeResource(colorRes);
        mSp.setProgressBackgroundColorSchemeColor(mIsChangeColor ? Color.LTGRAY : Color.MAGENTA);
        mIsChangeColor = !mIsChangeColor;
    }

    private void changeSwipeColor() {
        if (!mIsChangeSwipeColor) {
            //此处设置加载圈的颜色,两种方法,传参都是可变参数
            //mSp.setColorSchemeResources(colorRes);
            mSp.setColorSchemeColors(Color.GRAY, Color.GREEN, Color.YELLOW);
        }else {
            mSp.setColorSchemeColors(Color.BLACK);
        }
        mIsChangeSwipeColor = !mIsChangeSwipeColor;
    }

    private void changeDistance() {
        //setProgressViewEndTarget设置加载圈结束的位置,布尔值是设置是否有缩放效果布尔值是设置是否有缩放效果
        //mSp.setProgressViewEndTarget(false, 200);
        //setProgressViewOffset是设置加载圈出现位置以及结束的位置,布尔值是设置是否有缩放效果
        mSp.setProgressViewOffset(true, 20, 200);
    }
}
