package com.epam.androidtraining.adapter;

import android.database.Cursor;
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

public class MessageCursorRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerViewHolder> {

    @IntDef({MessageType.VIP, MessageType.USER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {

        int VIP = 0;
        int USER = 1;
    }

    private Cursor cursor;

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
        if (cursor == null) {
            return;
        }
        cursor.moveToPosition(pPosition);

        pHolder.mMessage.setText(cursor.getString(cursor.getColumnIndex(MessageModel.MessagesDb.MESSAGE)));

        Malevich.INSTANCE.load(cursor.getString(cursor.getColumnIndex(MessageModel.MessagesDb.URL))).into(pHolder.mImageView);
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
        return cursor != null ? cursor.getCount() : 0;
    }

    public void setItems(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    public void release() {
        if (cursor != null) {
            cursor = null;
        }
    }
}