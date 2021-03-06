package com.epam.androidtraining.adapter;

import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epam.androidtraining.R;
import com.epam.androidtraining.holder.MessageRecyclerViewHolder;
import com.epam.androidtraining.model.MessageModel;
import com.epam.training.imageloader.Malevich;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerViewHolder> {

    @IntDef({MessageType.VIP, MessageType.USER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {

        int VIP = 0;
        int USER = 1;
    }

    private final List<MessageModel> mMessageList;

    public MessageRecyclerAdapter() {
        mMessageList = new ArrayList<>();
    }

    public MessageRecyclerAdapter(final List<MessageModel> pMessageList) {
        mMessageList = pMessageList;
    }

    @Override
    public MessageRecyclerViewHolder onCreateViewHolder(final ViewGroup pParent, final int pViewType) {
        final int viewId;

        switch (pViewType) {
            case MessageType.VIP:
                viewId = R.layout.adapter_message_vip;
                break;
            case MessageType.USER:
                viewId = R.layout.adapter_message;
                break;
            default:
                viewId = R.layout.adapter_message;
                break;
        }
        final View view = LayoutInflater.from(pParent.getContext()).inflate(viewId, pParent, false);

        return new MessageRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MessageRecyclerViewHolder pHolder, final int pPosition) {
        final MessageModel messageModel = mMessageList.get(pPosition);

        pHolder.mMessage.setText(messageModel.getMessage());

        Malevich.INSTANCE.load(messageModel.getUrl()).into(pHolder.mImageView);
    }

    @Override
    public int getItemViewType(final int pPosition) {
        if (pPosition == 0) {
            return MessageType.VIP;
        } else {
            return MessageType.USER;
        }
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    public void setItems(List<MessageModel> items) {
        mMessageList.clear();
        mMessageList.addAll(items);
        notifyDataSetChanged();
    }
}