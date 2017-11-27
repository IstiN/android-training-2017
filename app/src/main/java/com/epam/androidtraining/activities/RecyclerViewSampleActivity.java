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

    public static final String URL_FORMAT = "http://lorempixel.com/200/200/cats/%s/";

    private List<MessageModel> mMessageList;

    @Override
    protected void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_recyclerview_sample);

        loadData();

        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new MessageRecyclerAdapter(mMessageList));
    }

    private void loadData() {
        mMessageList = new ArrayList<>();

        for (int i = 1; i < 50; i++) {

            mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998", String.format(URL_FORMAT, i)));
        }
    }
}
