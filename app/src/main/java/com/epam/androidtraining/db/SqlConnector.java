package com.epam.androidtraining.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.epam.androidtraining.db.sql.Tables;

public class SqlConnector extends SQLiteOpenHelper {

    private static final String NAME = "application.db";

    private static final int VERSION = 2;

    public SqlConnector(Context context) {
        //TODO read about SQLiteDatabase.CursorFactory
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.USERS_TABLE);
        db.execSQL(Tables.FRIENDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("SqlConnector", "onUpgrade from " + oldVersion + " to " + newVersion);
    }
}
