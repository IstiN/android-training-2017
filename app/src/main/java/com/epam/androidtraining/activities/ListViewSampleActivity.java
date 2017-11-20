package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.epam.androidtraining.R;
import com.epam.androidtraining.adapter.MessageListViewAdapter;
import com.epam.androidtraining.model.MessageModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewSampleActivity extends AppCompatActivity {

    private List<MessageModel> mMessageList;

    @Override
    protected void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.activity_list_view_sample);

        loadData();

        final ListView mListView = findViewById(R.id.list_view);
        mListView.setAdapter(new MessageListViewAdapter(this, mMessageList));
    }

    private void loadData() {
        mMessageList = new ArrayList<>();

        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
        mMessageList.add(new MessageModel("Hello, List View", "maxcriser", "16.01.1998"));
    }
}
