package com.epam.androidtraining.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.epam.androidtraining.model.MessageModel;
import com.epam.androidtraining.viewpager.MessageSlideFragment;

import java.util.List;

public class MessagePagerAdapter extends FragmentStatePagerAdapter {

    private final List<MessageModel> mMessageList;

    public MessagePagerAdapter(final FragmentManager fm, final List<MessageModel> pMessageList) {
        super(fm);

        mMessageList = pMessageList;
    }

    @Override
    public Fragment getItem(final int pPosition) {
        return MessageSlideFragment.newInstance(mMessageList.get(pPosition));
    }

    @Override
    public int getCount() {
        return mMessageList.size();
    }
}
