package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epam.androidtraining.R;
import com.epam.androidtraining.adapter.MessagePagerAdapter;
import com.epam.androidtraining.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerSampleActivity extends AppCompatActivity {

    private List<MessageModel> mMessageList;

    @Override
    protected void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_view_pager);

        loadData();

        final ViewPager mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MessagePagerAdapter(getSupportFragmentManager(), mMessageList));
    }

    private void loadData() {
        mMessageList = new ArrayList<>();

        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, View Pager", "maxcriser", "16.01.1998"));
    }
}
