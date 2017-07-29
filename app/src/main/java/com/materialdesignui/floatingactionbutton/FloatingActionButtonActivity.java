package com.materialdesignui.floatingactionbutton;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.materialdesignui.R;

public class FloatingActionButtonActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int DISTANCE = 300;
    private static final int DISTANCE2 = 220;

    private FloatingActionButton actionButton, actionButton1, actionButton2, actionButton3;
    private boolean mMenuOpen = false;
    private View mFlMenu;

    private boolean mIsChange = true;
    private FloatingActionButton mFabAdd;
    private boolean isAdd = false;
    private RelativeLayout mRlAddBill;
    private int[]                  llId     = new int[]{R.id.ll01,R.id.ll02,R.id.ll03,R.id.ll04};
    private LinearLayout[]         mLlArray = new LinearLayout[llId.length];
    private int[]                  mFabId   = new int[]{R.id.miniFab01,R.id.miniFab02,R.id.miniFab03,R.id.miniFab04};
    private FloatingActionButton[] mFabs    = new FloatingActionButton[mFabId.length];
    private AnimatorSet mAddBillTranslate1;
    private AnimatorSet mAddBillTranslate2;
    private AnimatorSet mAddBillTranslate3;
    private AnimatorSet mAddBillTranslate4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFlMenu.setVisibility(mIsChange ? View.VISIBLE : View.GONE);
                findViewById(R.id.rl_other_layout).setVisibility(mIsChange ? View.GONE : View.VISIBLE);
                mIsChange = !mIsChange;
            }
        });
        initView();
        initOtherView();
    }

    private void initView() {
        mFlMenu = findViewById(R.id.fl_menu);

        actionButton = (FloatingActionButton) findViewById(R.id.float_btn);
        actionButton1 = (FloatingActionButton) findViewById(R.id.float_btn1);
        actionButton2 = (FloatingActionButton) findViewById(R.id.float_btn2);
        actionButton3 = (FloatingActionButton) findViewById(R.id.float_btn3);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMenuOpen) {
                    hideMenu();
                }else {
                    showMenu();
                }
            }
        });
    }

    private void initOtherView() {
        mFabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);
        mRlAddBill = (RelativeLayout)findViewById(R.id.rlAddBill);
        for (int i = 0; i < llId.length;i++){
            mLlArray[i] = (LinearLayout)findViewById(llId[i]);
        }
        for (int i = 0; i < mFabId.length; i++){
            mFabs[i] = (FloatingActionButton)findViewById(mFabId[i]);
        }

        mAddBillTranslate1 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
        mAddBillTranslate2 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
        mAddBillTranslate3 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
        mAddBillTranslate4 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);

        mFabAdd.setOnClickListener(this);
        for (int i = 0; i < mFabId.length; i++){
            mFabs[i].setOnClickListener(this);
        }
    }


    private void showMenu() {
        mMenuOpen = true;
        int x = (int) actionButton.getX();
        int y = (int) actionButton.getY();
        ValueAnimator v1 = ValueAnimator.ofInt(x, x - DISTANCE);
        v1.setDuration(500);
        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton1.getY();
                int r = actionButton1.getWidth() + l;
                int b = actionButton1.getHeight() + t;
                actionButton1.layout(l, t, r, b);
            }
        });
        ValueAnimator v2x = ValueAnimator.ofInt(x, x - DISTANCE2);
        ValueAnimator v2y = ValueAnimator.ofInt(y, y - DISTANCE2);
        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton2.getY();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton2.getX();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        ValueAnimator v3 = ValueAnimator.ofInt(y, y - DISTANCE);
        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton3.getX();
                int r = actionButton3.getWidth() + l;
                int b = actionButton3.getHeight() + t;
                actionButton3.layout(l, t, r, b);
            }
        });
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    private void hideMenu() {
        mMenuOpen = false;
        int x = (int) actionButton1.getX();
        ValueAnimator v1 = ValueAnimator.ofInt(x, (int) actionButton.getX());
        v1.setDuration(500);
        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton1.getY();
                int r = actionButton1.getWidth() + l;
                int b = actionButton1.getHeight() + t;
                actionButton1.layout(l, t, r, b);
            }
        });
        x = (int) actionButton2.getX();
        int y = (int) actionButton2.getY();
        ValueAnimator v2x = ValueAnimator.ofInt(x, (int) actionButton.getX());
        ValueAnimator v2y = ValueAnimator.ofInt(y, (int) actionButton.getY());
        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton2.getY();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton2.getX();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        y = (int) actionButton3.getY();
        ValueAnimator v3 = ValueAnimator.ofInt(y, (int) actionButton.getY());
        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton3.getX();
                int r = actionButton3.getWidth() + l;
                int b = actionButton3.getHeight() + t;
                actionButton3.layout(l, t, r, b);
            }
        });
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAdd:
                mFabAdd.setImageResource(isAdd ? R.drawable.ic_add :R.drawable.ic_close);
                isAdd = !isAdd;
                mRlAddBill.setVisibility(isAdd ? View.VISIBLE : View.GONE);
                if (isAdd) {
                        mAddBillTranslate1.setTarget(mLlArray[0]);
                        mAddBillTranslate1.start();
                        mAddBillTranslate2.setTarget(mLlArray[1]);
                        mAddBillTranslate2.setStartDelay(150);
                        mAddBillTranslate2.start();
                        mAddBillTranslate3.setTarget(mLlArray[2]);
                        mAddBillTranslate3.setStartDelay(00);
                        mAddBillTranslate3.start();
                        mAddBillTranslate4.setTarget(mLlArray[3]);
                        mAddBillTranslate4.setStartDelay(250);
                        mAddBillTranslate4.start();
                    }
                break;
            case R.id.miniFab01:
            case R.id.miniFab02:
            case R.id.miniFab03:
            case R.id.miniFab04:
                hideFABMenu();
                break;
            default:
                break;
        }
    }

    private void hideFABMenu() {
        mRlAddBill.setVisibility(View.GONE);
        mFabAdd.setImageResource(R.drawable.ic_add);
        isAdd = false;
    }
}
