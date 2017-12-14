package com.epam.androidtraining.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.epam.androidtraining.utils.ContextHolder;

public interface IDbOperations {

    int insert(String table, ContentValues values);

    int bulkInsert(String table, ContentValues[] values);

    Cursor query(String table, @Nullable final String[] projection, @Nullable final String selection, @Nullable final String[] selectionArgs, @Nullable final String sortOrder);

    int delete(String table, @Nullable final String selection, @Nullable final String[] selectionArgs);

    int update(@NonNull final String table, @Nullable final ContentValues values, @Nullable final String selection, @Nullable final String[] selectionArgs);

    final class Imp {

        public static final String SYSTEM_SERVICE_NAME = "IDbOperations";

        public static IDbOperations newInstance(Context context) {
            return new DbOperations(new SqlConnector(context));
        }

        public static IDbOperations getInstance(Context context) {
            return (IDbOperations) context.getApplicationContext().getSystemService(SYSTEM_SERVICE_NAME);
        }

        public static IDbOperations getInstance() {
            return getInstance(ContextHolder.getContext());
        }
    }
}
