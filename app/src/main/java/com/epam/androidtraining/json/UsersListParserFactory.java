package com.epam.androidtraining.json;

import java.io.InputStream;

public class UsersListParserFactory {

    public IUserListParser createParser(InputStream pSource) throws Exception {
        return new UsersListGSONParser(pSource);
    }

    public IUserListParser createParserForResponceWithObject(InputStream pSource) {
        return new UserListGsonParserWithObject(pSource);
    }
}
