package com.epam.androidtraining.db.models;


import android.provider.BaseColumns;

import com.epam.androidtraining.db.annotations.dbLong;
import com.epam.androidtraining.db.annotations.dbString;
import com.epam.androidtraining.db.annotations.dbTable;
import com.epam.androidtraining.db.utils.DbUtils;

@dbTable("UserDb")
public class UserDb implements BaseColumns {

    public static final String TABLE = DbUtils.getTableName(UserDb.class);

    @dbString
    public static final String NAME = "name";

    @dbLong
    public static final String REGISTERED = "registered";

//    @dbEntity(FriendsDb.class)
    public static final String FRIENDS = "friends";

}
