package com.materialdesignui.swiperefreshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.materialdesignui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DF on 2017/7/24.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private Context mContext;
    private List<String> mList;

    public RecyclerAdapter(Context context) {
        this.mContext = context;
        this.mList = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        holder.mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.render(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void reFreshData(List<String> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView mTv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_in_item);
        }

        public void render(String text){
            mTv.setText(text);
        }
    }
}
