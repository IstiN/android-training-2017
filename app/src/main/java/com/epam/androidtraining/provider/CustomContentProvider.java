package com.epam.androidtraining.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.epam.androidtraining.db.IDbOperations;

public class CustomContentProvider extends ContentProvider {
    private static final String TAG = "CustomContentProvider";
    public static final String PROVIDER_URI = "content://com.epam.androidtraining.provider.CustomContentProvider";

    private IDbOperations mDatabase;

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate() called");
        mDatabase = IDbOperations.Imp.newInstance(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull final Uri uri, @Nullable final String[] projection, @Nullable final String selection, @Nullable final String[] selectionArgs, @Nullable final String sortOrder) {
        return mDatabase.query(uri.getLastPathSegment(), projection, selection, selectionArgs, sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull final Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull final Uri uri, @Nullable final ContentValues values) {
        return Uri.parse(uri + "/" + mDatabase.insert(uri.getLastPathSegment(), values));
    }

    @Override
    public int delete(@NonNull final Uri uri, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        return mDatabase.delete(uri.getLastPathSegment(), selection, selectionArgs);
    }

    @Override
    public int update(@NonNull final Uri uri, @Nullable final ContentValues values, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        return mDatabase.update(uri.getLastPathSegment(), values, selection, selectionArgs);
    }

    @Override
    public int bulkInsert(@NonNull final Uri uri, @NonNull final ContentValues[] values) {
        return mDatabase.bulkInsert(uri.getLastPathSegment(), values);
    }
}
