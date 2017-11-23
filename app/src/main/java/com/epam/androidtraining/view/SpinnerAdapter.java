package com.epam.androidtraining.view;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.epam.androidtraining.R;

import java.util.List;

public class SpinnerAdapter extends BaseRecyclerViewAdapter<SpinnerAdapter.SpinnerViewHolder, SomeModel> {

    private OnItemSelectedListener onItemSelectedListener;

    public SpinnerAdapter(List<SomeModel> mFiltersList) {
        super(mFiltersList);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_dropdown;
    }

    @Override
    public SpinnerViewHolder createViewHolder(View itemView, int viewType) {
        return new SpinnerViewHolder(itemView);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.onItemSelectedListener = listener;
    }

    @Override
    public void onBindViewHolder(SpinnerViewHolder holder, int position) {
        holder.text.setText(getData().get(position).getName());
    }

    public class SpinnerViewHolder extends BaseRecyclerViewVH {

        public final TextView text;

        SpinnerViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.dropDownText);
        }

    }

    public interface OnItemSelectedListener {

        void onItemSelected(View view, int position);

        void onNothingSelected();
    }

}
