package com.epam.androidtraining.json;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class UsersListGSONParser implements IUserListParser {

    private final InputStream mIntputStream;

    public UsersListGSONParser(InputStream pIntputStream) {
        this.mIntputStream = pIntputStream;
    }

    @Override
    public IUsersList parse() throws Exception {
        Reader reader = new InputStreamReader(mIntputStream);
        UserGson[] result = new Gson().fromJson(reader, UserGson[].class);
        return new UsersListGson(Arrays.asList(result));
    }
}
