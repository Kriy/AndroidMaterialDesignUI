package com.materialdesignui.cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DF on 2017/7/31.
 */

public class CardRecAdapter extends RecyclerView.Adapter<CardRecAdapter.ViewHolder> {

    private List<String> mList;

    public CardRecAdapter() {
        this.mList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            mList.add("测试中的数据。。。" + i);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.render(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_card);
        }

        public void render(String text){
            mTv.setText(text);
        }
    }
}
