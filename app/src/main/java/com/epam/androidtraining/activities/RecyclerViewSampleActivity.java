package com.epam.androidtraining.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
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
        setContentView(getLayoutId());

        loadData();

        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(new MessageRecyclerAdapter(mMessageList));
    }

    private @LayoutRes int getLayoutId() {
        return R.layout.activity_recyclerview_sample;
    }

    private void loadData() {
        mMessageList = new ArrayList<>();

        String[] urls = {"http://www.petmd.com/sites/default/files/scared-kitten-shutterstock_191443322.jpg",
        "http://r.ddmcdn.com/s_f/o_1/cx_0/cy_0/cw_300/ch_300/w_300/APL/uploads/2014/10/kitten-cuteness300.jpg",
        "https://cmeimg-a.akamaihd.net/640/clsd/getty/c64f76dc20c246ca88ee180fe4b4b781",
        "http://r.ddmcdn.com/s_f/o_1/cx_462/cy_245/cw_1349/ch_1349/w_720/APL/uploads/2015/06/caturday-shutterstock_149320799.jpg",
        "https://vetstreet.brightspotcdn.com/dims4/default/a1a90c7/2147483647/thumbnail/180x180/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F0d%2Ff2e4c0b3a611e092fe0050568d634f%2Ffile%2Fhub-cats-senior.jpg",
        "https://media.boingboing.net/wp-content/uploads/2017/03/surprised-cat-04.jpg",
        "http://cdn1-www.cattime.com/assets/uploads/gallery/persian-cats-and-kittens/persian-cats-and-kittens-1.jpg"};
        for (int i = 1; i < urls.length; i++) {

            mMessageList.add(new MessageModel("Hello, Recycler View", "maxcriser", "16.01.1998", urls[i]));
        }
    }
}
