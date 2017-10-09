package com.epam.androidtraining.json;

public class UserParserFactory {


    public IUserParser createParser(String pSource) {
        return new UserJSONObjectParser(pSource);
    }

}
