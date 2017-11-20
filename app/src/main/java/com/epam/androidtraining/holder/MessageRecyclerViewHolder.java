package com.epam.androidtraining.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epam.androidtraining.R;

public class MessageRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mDate;
    public TextView mSender;
    public TextView mMessage;

    public MessageRecyclerViewHolder(final View pView) {
        super(pView);

        mDate = pView.findViewById(R.id.message_date);
        mSender = pView.findViewById(R.id.message_sender);
        mMessage = pView.findViewById(R.id.message);
    }
}