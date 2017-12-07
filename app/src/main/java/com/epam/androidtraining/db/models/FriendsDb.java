package com.epam.androidtraining.db.models;

import android.provider.BaseColumns;

import com.epam.androidtraining.db.annotations.dbInteger;
import com.epam.androidtraining.db.annotations.dbString;
import com.epam.androidtraining.db.annotations.dbTable;
import com.epam.androidtraining.db.utils.DbUtils;

@dbTable("FriendsDb")
public class FriendsDb implements BaseColumns {

    public static final String TABLE = DbUtils.getTableName(FriendsDb.class);

    @dbString
    public static final String NAME = "name";

    @dbInteger
    public static final String USER_ID = "user_id";
}
