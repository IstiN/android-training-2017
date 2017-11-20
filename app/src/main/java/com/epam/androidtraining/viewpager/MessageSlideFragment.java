package com.epam.androidtraining.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.model.MessageModel;

public class MessageSlideFragment extends Fragment {

    public static String EXTRA_MESSAGE_MODEL = "extra_message_model";

    public static MessageSlideFragment newInstance(final MessageModel pMessageModel) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_MESSAGE_MODEL, pMessageModel);

        final MessageSlideFragment searchFragment = new MessageSlideFragment();
        searchFragment.setArguments(bundle);

        return searchFragment;
    }

    private TextView mDate;
    private TextView mMessage;
    private TextView mSender;

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final MessageModel messageModel = (MessageModel) getArguments().getSerializable(EXTRA_MESSAGE_MODEL);

        initViews(view);
        bindViews(messageModel);
    }

    private void initViews(final View pView) {
        mDate = pView.findViewById(R.id.message_date);
        mSender = pView.findViewById(R.id.message_sender);
        mMessage = pView.findViewById(R.id.message);
    }

    private void bindViews(final MessageModel pMessageModel) {
        mDate.setText(pMessageModel.getDate());
        mSender.setText(pMessageModel.getSender());
        mMessage.setText(pMessageModel.getMessage());
    }

    @Override
    public View onCreateView(final LayoutInflater pInflater, final ViewGroup pContainer, final Bundle pSavedInstanceState) {
        return pInflater.inflate(R.layout.fragment_message, pContainer, false);
    }
}