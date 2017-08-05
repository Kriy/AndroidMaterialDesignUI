package com.materialdesignui.nestedscrollview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by DF on 2017/8/5.
 */

public class TestNestedScrollChile extends LinearLayout implements NestedScrollingChild {


    private NestedScrollingChildHelper mHelper;

    public TestNestedScrollChile(Context context) {
        this(context, null);
    }

    public TestNestedScrollChile(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestNestedScrollChile(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new NestedScrollingChildHelper(this);
        setBackgroundColor(Color.CYAN);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        super.setNestedScrollingEnabled(enabled);
        mHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return mHelper.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return mHelper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        mHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return mHelper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return mHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return mHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return mHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return mHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}
