package com.epam.androidtraining.json;

import java.util.List;

public class UsersListGson implements IUsersList {

    private List<UserGson> mUsersLists;

    public UsersListGson(List<UserGson> mUsersLists) {
        this.mUsersLists = mUsersLists;
    }

    @Override
    public List<UserGson> getUsersList() {
        return mUsersLists;
    }
}
