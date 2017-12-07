package com.epam.androidtraining.db;

import android.database.Cursor;

import com.epam.androidtraining.utils.ContextHolder;

public interface IDbOperations {

    int insert();

    int bulkInsert();

    Cursor query();

    int delete();

    final class Imp {
        public static final String SYSTEM_SERVICE_NAME = "IDbOperations";

        public static DbOperations newInstance() {
            return new DbOperations();
        }

        public static DbOperations getInstance() {
            return (DbOperations) ContextHolder.getContext().getSystemService(SYSTEM_SERVICE_NAME);
        }
    }
}
