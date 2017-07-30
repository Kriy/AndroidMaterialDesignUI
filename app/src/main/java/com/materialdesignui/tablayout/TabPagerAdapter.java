package com.materialdesignui.tablayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DF on 2017/7/30.
 */

public class TabPagerAdapter extends PagerAdapter {

    private Context mContext;
    private static final String[] mTitles = {"tab1", "tab2", "tab3"};
    private int[] mImageIds = {R.drawable.tab_01, R.drawable.tab_02, R.drawable.tab_03};
    private final List<TextView> mList;

    public TabPagerAdapter(Context context) {
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
        Drawable drawable = ContextCompat.getDrawable(mContext, mImageIds[position]);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 5, drawable.getIntrinsicHeight() / 5);

        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        SpannableString spannableString = new SpannableString("   " + mTitles[position]);
        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }
}
