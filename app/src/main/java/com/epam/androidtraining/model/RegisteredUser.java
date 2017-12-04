package com.epam.androidtraining.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegisteredUser {

    @SerializedName("name")
    private String mUserName;

    @SerializedName("index")
    private String mId;

    @SerializedName("registered")
    private Long mRegistered;


    @SerializedName("friends")
    private List<Friend> mFriends;

    public RegisteredUser(String mUserName, String mId, Long mRegistered, List<Friend> mFriends) {
        this.mUserName = mUserName;
        this.mId = mId;
        this.mRegistered = mRegistered;
        this.mFriends = mFriends;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getId() {
        return mId;
    }

    public Long getRegistered() {
        return mRegistered;
    }

    public List<Friend> getFriends() {
        return mFriends;
    }
}
