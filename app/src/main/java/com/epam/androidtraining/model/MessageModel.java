package com.epam.androidtraining.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.epam.androidtraining.db.annotations.dbString;
import com.epam.androidtraining.db.annotations.dbTable;
import com.epam.androidtraining.db.utils.DbUtils;

import java.io.Serializable;

public class MessageModel implements Serializable {

    private String mMessage;
    private String mUrl;

    public MessageModel(final String pMessage, String mUrl) {
        mMessage = pMessage;
        this.mUrl = mUrl;
    }

    public static MessageModel fromCursor(Cursor cursor) {
        return new MessageModel(
                cursor.getString(cursor.getColumnIndex(MessagesDb.MESSAGE)),
                cursor.getString(cursor.getColumnIndex(MessagesDb.URL))
        );
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessagesDb.MESSAGE, mMessage);
        contentValues.put(MessagesDb.URL, mUrl);
        return contentValues;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getUrl() {
        return mUrl;
    }

    @dbTable("MessagesDb")
    public static class MessagesDb implements BaseColumns {

        public static final String TABLE = DbUtils.getTableName(MessagesDb.class);

        @dbString
        public static final String MESSAGE = "name";

        @dbString
        public static final String URL = "url";
    }
}
