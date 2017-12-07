package com.epam.androidtraining.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

import com.epam.androidtraining.db.annotations.dbInteger;
import com.epam.androidtraining.db.annotations.dbLong;
import com.epam.androidtraining.db.annotations.dbString;
import com.epam.androidtraining.db.annotations.dbTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SqlConnector extends SQLiteOpenHelper {

    private static final String TAG = SqlConnector.class.getSimpleName();

    private static final String NAME = "application.db";

    private static final int VERSION = 2;

    private static final String TABLE_TEMPLATE =
            "CREATE TABLE IF NOT EXISTS %s (" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,%s)";

    public SqlConnector(Context context) {
        //TODO read about SQLiteDatabase.CursorFactory
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db, DbModels.DB_MODELS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("SqlConnector", "onUpgrade from " + oldVersion + " to " + newVersion);
    }


    private void createTables(SQLiteDatabase readableConnection, Class<?>[] tableClassArray) {

        readableConnection.beginTransaction();

        try {
            for (Class<?> tableClass : tableClassArray) {
                dbTable dbTableAnnotation = tableClass.getAnnotation(dbTable.class);
                if (dbTableAnnotation != null) {
                    String dbTableName = dbTableAnnotation.value();

                    if (TextUtils.isEmpty(dbTableName)) {
                        return;
                    }

                    StringBuilder stringBuilder = new StringBuilder();

                    Field[] fields = tableClass.getFields();
                    final int fieldCount = fields.length;
                    for (int i = 0; i < fieldCount; i++) {
                        Field field = fields[i];
                        Annotation[] fieldAnnotations = field.getAnnotations();
                        String fieldName = (String) field.get(null);
                        String fieldType = null;

                        for (Annotation fieldAnnotation : fieldAnnotations) {
                            Class<?> fieldAnnotationType = fieldAnnotation.annotationType();
                            if (fieldAnnotationType.equals(dbString.class)) {
                                fieldType = ((dbString) fieldAnnotation).value();
                            } else if (fieldAnnotationType.equals(dbLong.class)) {
                                fieldType = ((dbLong) fieldAnnotation).value();
                            } else if (fieldAnnotationType.equals(dbInteger.class)) {
                                fieldType = ((dbInteger) fieldAnnotation).value();
                            }
                            if (!TextUtils.isEmpty(fieldType)) {
                                stringBuilder.append(fieldName + " " + fieldType + ",");
                            }
                        }


                    }

                    //TODO think about solution if last field marked some annotation;
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);

                    String tableCreteQuery = String.format(TABLE_TEMPLATE, dbTableName, stringBuilder.toString());
                    readableConnection.execSQL(tableCreteQuery);

                }
            }
            readableConnection.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "create table exception", e);
        } finally {
            readableConnection.endTransaction();
        }

    }
}
