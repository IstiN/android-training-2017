package com.epam.androidtraining.adapter;

import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.androidtraining.R;
import com.epam.androidtraining.holder.MessageRecyclerViewHolder;
import com.epam.androidtraining.model.MessageModel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerViewHolder> {

    @IntDef({MessageType.VIP, MessageType.USER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {

        int VIP = 0;
        int USER = 1;
    }

    private List<MessageModel> mMessageList;

    public MessageRecyclerAdapter(final List<MessageModel> pMessageList) {
        mMessageList = pMessageList;
    }

    @Override
    public MessageRecyclerViewHolder onCreateViewHolder(final ViewGroup pParent, final int pViewType) {
        final View view = LayoutInflater.from(pParent.getContext()).inflate(R.layout.adapter_message, pParent, false);

        return new MessageRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MessageRecyclerViewHolder pHolder, final int pPosition) {
        final MessageModel messageModel = mMessageList.get(pPosition);

        pHolder.mSender.setText(messageModel.getSender());
        pHolder.mDate.setText(messageModel.getDate());
        pHolder.mMessage.setText(messageModel.getMessage());
    }

    @Override
    public int getItemViewType(final int pPosition) {
        return super.getItemViewType(pPosition);
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }
}