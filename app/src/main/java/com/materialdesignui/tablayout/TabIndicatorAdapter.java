package com.materialdesignui.tablayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DF on 2017/7/30.
 */

public class TabIndicatorAdapter extends PagerAdapter {


    private Context mContext;
    private static final String[] mTitles = {"tabbat1", "tabbat2", "tabbat3"};
    private final List<TextView> mList;

    public TabIndicatorAdapter(Context context) {
        this.mContext = context;
        mList = new ArrayList<>();

        TextView tv;
        for (int i = 0; i < 3; i++) {
            tv = new TextView(mContext);
            mList.add(tv);
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position));
        mList.get(position).setText(mTitles[position]);
        return mList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
