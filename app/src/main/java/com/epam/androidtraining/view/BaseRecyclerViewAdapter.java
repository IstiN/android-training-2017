package com.epam.androidtraining.view;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<ViewHolder extends BaseRecyclerViewVH, Model> extends RecyclerView.Adapter<ViewHolder> {

    private List<Model> mDataList = new ArrayList<>();

    @LayoutRes
    public abstract int getItemLayoutId(int viewType);

    public abstract ViewHolder createViewHolder(View itemView, int viewType);

    public BaseRecyclerViewAdapter() {
    }

    public BaseRecyclerViewAdapter(List<Model> dataList) {
        this.mDataList = dataList;
    }

    @Override
    public final ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(viewType), parent, false);
        final ViewHolder viewHolder = createViewHolder(itemLayoutView, viewType);

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public List<Model> getData() {
        return this.mDataList;
    }

    public void setData(List<Model> dataList) {
        this.mDataList = dataList;
        notifyDataSetChanged();
    }

    public void clearData() {
        this.mDataList.clear();
        notifyDataSetChanged();
    }

    public void addData(List<Model> dataList) {
        final int oldCount = getItemCount();
        this.mDataList.addAll(dataList);
        notifyItemRangeInserted(oldCount + 1, dataList.size());
    }

    public void addData(List<Model> dataList, int position) {
        this.mDataList.addAll(position, dataList);
        notifyItemRangeInserted(position + 1, dataList.size());
    }

    public void addItem(final int fromPosition, final Model item) {
        this.mDataList.add(fromPosition, item);
        notifyItemInserted(fromPosition);
    }

    public void removeItem(final Model item) {
        final int position = this.mDataList.indexOf(item);
        final boolean removed = this.mDataList.remove(item);
        if (removed) {
            notifyItemRemoved(position);
        }
    }

    public void removeItem(int position) {
        this.mDataList.remove(position);
        notifyItemRemoved(position);
    }

    public Model getItemByPosition(int position) {
        return mDataList.get(position);
    }
}
