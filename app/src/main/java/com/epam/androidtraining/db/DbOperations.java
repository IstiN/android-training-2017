package com.epam.androidtraining.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class DbOperations implements IDbOperations {

    private final SQLiteOpenHelper mHelper;

    public DbOperations(final SQLiteOpenHelper pHelper) {
        mHelper = pHelper;
    }

    @Override
    public int insert(final String table, final ContentValues values) {
        final SQLiteDatabase database = mHelper.getWritableDatabase();
        long id = 0;

        database.beginTransaction();

        try {
            id = database.insert(table, "", values);

            database.setTransactionSuccessful();
        } catch (final Exception e) {
            Log.e(this.getClass().getSimpleName(), e.getLocalizedMessage());
        } finally {
            database.endTransaction();
        }

        return (int) id;
    }

    @Override
    public int bulkInsert(final String table, final ContentValues[] values) {
        final SQLiteDatabase database = mHelper.getWritableDatabase();
        int inserted = 0;

        database.beginTransaction();

        try {
            for (final ContentValues value : values) {
                database.insert(table, "", value);

                inserted++;
            }

            database.setTransactionSuccessful();
        } catch (final Exception e) {
            Log.e(this.getClass().getSimpleName(), e.getLocalizedMessage());
        } finally {
            database.endTransaction();
        }

        return inserted;
    }

    @Override
    public Cursor query(final String table, @Nullable final String[] projection, @Nullable final String selection, @Nullable final String[] selectionArgs, @Nullable final String sortOrder) {
        return mHelper.getReadableDatabase().query(table, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public int delete(final String table, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        final SQLiteDatabase database = mHelper.getWritableDatabase();
        int count = 0;

        database.beginTransaction();

        try {
            count = database.delete(table, selection, selectionArgs);

            database.setTransactionSuccessful();
        } catch (final Exception e) {
            Log.e(this.getClass().getSimpleName(), e.getLocalizedMessage());
        } finally {
            database.endTransaction();
        }

        return count;
    }

    @Override
    public int update(@NonNull final String table, @Nullable final ContentValues values, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        final SQLiteDatabase database = mHelper.getWritableDatabase();
        int count = 0;

        database.beginTransaction();

        try {
            count = database.update(table, values, selection, selectionArgs);

            database.setTransactionSuccessful();
        } catch (final Exception e) {
            Log.e(this.getClass().getSimpleName(), e.getLocalizedMessage());
        } finally {
            database.endTransaction();
        }

        return count;
    }
}
