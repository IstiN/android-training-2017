package com.epam.androidtraining.model;

import com.google.gson.annotations.SerializedName;

public class Friend {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    public int getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }
}
