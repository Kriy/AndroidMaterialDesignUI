package com.materialdesignui.tablayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DF on 2017/7/30.
 */

public class TabVerPagerAdapter extends PagerAdapter {


    private Context mContext;
    private static final String[] mTitles = {"tabbat1", "tabbat2", "tabbat3"};
    private int[] mImageIds = {R.drawable.tab_01, R.drawable.tab_02, R.drawable.tab_03};
    private final List<TextView> mList;

    public TabVerPagerAdapter(Context context) {
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


    public View getTabView(int position){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
        TextView tv= (TextView) view.findViewById(R.id.txt_title);
        tv.setText(mTitles[position]);
        ImageView img = (ImageView) view.findViewById(R.id.img_title);
        img.setImageResource(mImageIds[position]);
        return view;
    }
}
