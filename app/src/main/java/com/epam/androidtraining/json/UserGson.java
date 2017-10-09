package com.epam.androidtraining.json;

import com.google.gson.annotations.SerializedName;

public class UserGson implements IUser {

    @SerializedName("avatar")
    private String mAvatar;

    @SerializedName("id")
    private long mId;

    @SerializedName("name")
    private String mName;

    @Override
    public long getId() {
        return mId;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public String getAvatar() {
        return mAvatar;
    }
}
