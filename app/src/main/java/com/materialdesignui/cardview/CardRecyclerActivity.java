package com.materialdesignui.cardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.materialdesignui.R;

public class CardRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler);

        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv_card);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(new CardRecAdapter());

    }

}
