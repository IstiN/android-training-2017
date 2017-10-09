package com.epam.androidtraining.json;

import org.json.JSONObject;

class UserJSONWrapper implements IUser {

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String AVATAR = "avatar";

    private final JSONObject mJsonObject;

    UserJSONWrapper(final JSONObject pJsonObject) {
        mJsonObject = pJsonObject;
    }

    @Override
    public long getId() {
        return mJsonObject.optLong(ID);
    }

    @Override
    public String getName() {
        return mJsonObject.optString(NAME);
    }

    @Override
    public String getAvatar() {
        return mJsonObject.optString(AVATAR);
    }
}
