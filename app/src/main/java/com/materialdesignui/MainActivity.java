package com.materialdesignui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.materialdesignui.appbarlayout.AppbarLayoutActivity;
import com.materialdesignui.cardview.CardViewActivity;
import com.materialdesignui.collapsingtoolbarlayout.CollapsingToolbarLayoutActivity;
import com.materialdesignui.coordinatorlayout.CoordinatorLayoutActivity;
import com.materialdesignui.floatingactionbutton.FloatingActionButtonActivity;
import com.materialdesignui.navigationview.NavigationActivity;
import com.materialdesignui.nestedscrollview.NestedScrollViewActivity;
import com.materialdesignui.recyclerview.RecyclerViewActivity;
import com.materialdesignui.snackbar.SnackbarActivity;
import com.materialdesignui.swiperefreshlayout.SwipeRefreshLayoutActivity;
import com.materialdesignui.tablayout.TabLayoutActivity;
import com.materialdesignui.textinputedittext.TextInputEditTextActivity;
import com.materialdesignui.textinputlayout.TextInputLayoutActivity;
import com.materialdesignui.toolbar.ToolbarActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.btn_snackbar).setOnClickListener(this);
        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_appbarLayout).setOnClickListener(this);
        findViewById(R.id.btn_recyclerview).setOnClickListener(this);
        findViewById(R.id.btn_cardview).setOnClickListener(this);
        findViewById(R.id.btn_tablayout).setOnClickListener(this);
        findViewById(R.id.btn_navigationView).setOnClickListener(this);
        findViewById(R.id.btn_coordinatorlayout).setOnClickListener(this);
        findViewById(R.id.btn_floating_action_button).setOnClickListener(this);
        findViewById(R.id.btn_swiperefreshlayout).setOnClickListener(this);
        findViewById(R.id.btn_nestedscrollview).setOnClickListener(this);
        findViewById(R.id.btn_collapsingtoolbarlayout).setOnClickListener(this);
        findViewById(R.id.btn_textinputlayout).setOnClickListener(this);
        findViewById(R.id.btn_textinputedittext).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        if (id == R.id.btn_snackbar) {
            intent.setClass(this, SnackbarActivity.class);
        } else if (id == R.id.btn_toolbar) {
            intent.setClass(this, ToolbarActivity.class);
        } else if (id == R.id.btn_appbarLayout) {
            intent.setClass(this, AppbarLayoutActivity.class);
        } else if (id == R.id.btn_recyclerview) {
            intent.setClass(this, RecyclerViewActivity.class);
        } else if (id == R.id.btn_cardview) {
            intent.setClass(this, CardViewActivity.class);
        } else if (id == R.id.btn_tablayout) {
            intent.setClass(this, TabLayoutActivity.class);
        } else if (id == R.id.btn_navigationView) {
            intent.setClass(this, NavigationActivity.class);
        } else if (id == R.id.btn_coordinatorlayout) {
            intent.setClass(this, CoordinatorLayoutActivity.class);
        } else if (id == R.id.btn_floating_action_button) {
            intent.setClass(this, FloatingActionButtonActivity.class);
        } else if (id == R.id.btn_swiperefreshlayout) {
            intent.setClass(this, SwipeRefreshLayoutActivity.class);
        } else if (id == R.id.btn_nestedscrollview) {
            intent.setClass(this, NestedScrollViewActivity.class);
        } else if (id == R.id.btn_collapsingtoolbarlayout) {
            intent.setClass(this, CollapsingToolbarLayoutActivity.class);
        } else if (id == R.id.btn_textinputlayout) {
            intent.setClass(this, TextInputLayoutActivity.class);
        } else if (id == R.id.btn_textinputedittext) {
            intent.setClass(this, TextInputEditTextActivity.class);
        }
        startActivity(intent);
    }
}
