package com.materialdesignui.snackbar;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.materialdesignui.R;

/**
 * Created by DF on 2017/7/24.
 */

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private int mTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn_action).setOnClickListener(this);
        findViewById(R.id.btn_time).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_image).setOnClickListener(this);
        ((SeekBar) findViewById(R.id.sk)).setOnSeekBarChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn) {
            Snackbar.make(v, "test", Snackbar.LENGTH_SHORT).show();
        } else if (id == R.id.btn_action) {
            setAction(v);
        } else if (id == R.id.btn_time) {
            setTime(v);
        } else if (id == R.id.btn_color) {
            setColor(v);
        } else if (id == R.id.btn_image) {
            addImage(v);
        }
    }

    private void setAction(View v) {
        Snackbar.make(v, "test", Snackbar.LENGTH_SHORT)
                .setAction("这是Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SnackbarActivity.this, "点击了Action", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    private void setTime(View v) {
        //mTime = 0时，即显示时间为Snackbar.LENGTH_LONG
        if (mTime != 0) {
            Toast.makeText(SnackbarActivity.this, "显示时间:" + mTime * 1000, Toast.LENGTH_SHORT).show();
        }
        Snackbar.make(v, "test", Snackbar.LENGTH_INDEFINITE)
                .setDuration(mTime * 1000)
                .show();
    }

    private void setColor(View v) {
        Snackbar snackbar = Snackbar.make(v, "test", Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(Color.MAGENTA);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.CYAN);
        snackbar.show();
    }

    private void addImage(View v) {
        Snackbar snackbar = Snackbar.make(v, "test", Snackbar.LENGTH_SHORT);
        Drawable img = getResources().getDrawable(R.mipmap.ic_launcher);
        img.setBounds(0, 0, img.getMinimumWidth() - 20, img.getMinimumHeight() - 80);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setCompoundDrawables(img, null, null, null);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setGravity(Gravity.CENTER_VERTICAL);
        snackbar.show();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTime = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
