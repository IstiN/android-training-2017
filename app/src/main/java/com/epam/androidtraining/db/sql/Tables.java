package com.epam.androidtraining.db.sql;

import com.epam.androidtraining.db.models.FriendsDb;
import com.epam.androidtraining.db.models.UserDb;

public class Tables {
    public static final String USERS_TABLE
            = "CREATE TABLE IF NOT EXISTS " +
            UserDb.TABLE + "(" +
            UserDb.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            UserDb.NAME + " VARCHAR (500)," +
            UserDb.REGISTERED + " INTEGER )";

    public static final String FRIENDS_TABLE
            = "CREATE TABLE IF NOT EXISTS " +
            FriendsDb.TABLE + "(" +
            FriendsDb.ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            FriendsDb.NAME + " VARCHAR(500)," +
            FriendsDb.USER_ID + " INTEGER )";

    public static final String INSERT_TEST_USER =
            "INSERT INTO " + UserDb.TABLE + "(" +
             UserDb.NAME+ "," + UserDb.REGISTERED + ")" +
            " VALUES (?,?)";
}
