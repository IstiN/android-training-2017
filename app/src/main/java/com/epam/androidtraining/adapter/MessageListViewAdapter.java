package com.epam.androidtraining.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.model.MessageModel;

import java.util.List;

public class MessageListViewAdapter extends ArrayAdapter<MessageModel> {

    private final List<MessageModel> mMessageList;

    public MessageListViewAdapter(final Context pContext, final List<MessageModel> pMessageList) {
        super(pContext, R.layout.adapter_message, pMessageList);

        mMessageList = pMessageList;
    }

    @Override
    public View getView(final int pPosition, View pConvertView, @NonNull final ViewGroup pParent) {
        final MessageModel messageModel = mMessageList.get(pPosition);
        final MessageListViewHolder viewHolder;

        if (pConvertView == null) {

            viewHolder = new MessageListViewHolder();

            final LayoutInflater inflater = LayoutInflater.from(getContext());
            pConvertView = inflater.inflate(R.layout.adapter_message, pParent, false);

            viewHolder.mDate = pConvertView.findViewById(R.id.message_date);
            viewHolder.mSender = pConvertView.findViewById(R.id.message_sender);
            viewHolder.mMessage = pConvertView.findViewById(R.id.message);

            pConvertView.setTag(viewHolder);
        } else {
            viewHolder = (MessageListViewHolder) pConvertView.getTag();
        }

        viewHolder.mMessage.setText(messageModel.getMessage());

        return pConvertView;
    }

    private static class MessageListViewHolder {
        TextView mDate;
        TextView mSender;
        TextView mMessage;
    }
}