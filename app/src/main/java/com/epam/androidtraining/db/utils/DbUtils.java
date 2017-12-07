package com.epam.androidtraining.db.utils;

public class DbUtils {

    public static String getTableName(Class<?> clazz) {
        return clazz.getSimpleName();
    }
}
