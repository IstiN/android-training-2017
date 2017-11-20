package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.adapter.MessageRecyclerAdapter;
import com.epam.androidtraining.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSampleActivity extends AppCompatActivity {

    private List<MessageModel> mMessageList;

    @Override
    protected void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_recyclerview_sample);

        loadData();

        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mRecyclerView.setAdapter(new MessageRecyclerAdapter(mMessageList));
    }

    private void loadData() {
        mMessageList = new ArrayList<>();

        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998"));
    }
}
