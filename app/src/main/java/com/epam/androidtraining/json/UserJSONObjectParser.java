package com.epam.androidtraining.json;

import org.json.JSONObject;

class UserJSONObjectParser implements IUserParser {

    private final String mSource;

    UserJSONObjectParser(final String pSource) {
        mSource = pSource;
    }

    @Override
    public IUser parse() throws Exception {
        final JSONObject jsonObject = new JSONObject(mSource);
        return new UserJSONWrapper(jsonObject);
    }

}
