package com.epam.androidtraining.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

public class BaseRecyclerViewVH extends RecyclerView.ViewHolder implements View.OnClickListener, AdapterView.OnItemClickListener {

    private AdapterView.OnItemClickListener mOnItemClickListener;

    public BaseRecyclerViewVH(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public final void onClick(View v) {
        if (mOnItemClickListener == null) {
            return;
        }
        final int adapterPosition = getAdapterPosition();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
