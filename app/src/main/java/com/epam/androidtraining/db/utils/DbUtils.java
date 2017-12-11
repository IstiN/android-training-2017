package com.epam.androidtraining.db.utils;

import android.net.Uri;

import com.epam.androidtraining.provider.CustomContentProvider;

public class DbUtils {

    public static String getTableName(final Class<?> clazz) {
        return clazz.getSimpleName();
    }

    public static Uri getTableUri(final Class<?> clazz) {
        return Uri.parse(CustomContentProvider.PROVIDER_URI + "/" + getTableName(clazz));
    }

}
