package com.epam.androidtraining.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidtraining.BuildConfig;
import com.epam.androidtraining.Constants;
import com.epam.androidtraining.db.models.UserDb;
import com.epam.androidtraining.mocks.Mocks;
import com.epam.androidtraining.model.ListRegisteredUsers;
import com.epam.androidtraining.model.RegisteredUser;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = Constants.SDK_VERSION
)
public class DatabaseTest {

    private SqlConnector mSqlConnector;

    @Before
    public void setUp() {
        mSqlConnector = new SqlConnector(RuntimeEnvironment.application);
    }

    @Test
    public void putRegisteredUsersToDb() {
        RegisteredUser[] usersArray = readRegisteredUsers();
        assertEquals(usersArray.length, 5);
//        int resultCount =  IDbOperations.Imp.getInstance().bulkInsert(usersArray);
//        assertEquals(resultCount, 5);

        SQLiteDatabase writeConnection = mSqlConnector.getWritableDatabase();
        writeConnection.beginTransaction();

        for (RegisteredUser user : usersArray) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UserDb.NAME, user.getUserName());
            contentValues.put(UserDb.REGISTERED, user.getRegistered());

            //TODO read about nullColumnHack
            //TODO read about conflicts
            writeConnection.insert(UserDb.TABLE, null, contentValues);
        }

        writeConnection.setTransactionSuccessful();
        writeConnection.endTransaction();

        SQLiteDatabase readableConnection = mSqlConnector.getReadableDatabase();
        Cursor cursor = readableConnection.query(UserDb.TABLE,
                null,
                UserDb.NAME + "=? AND " + UserDb.REGISTERED + " NOT NULL",
                new String[]{"Shelia Chang"}, null, null, null, null);

        final List<RegisteredUser> registeredUsers = new ArrayList<>();
        while (cursor.moveToNext()) {
            String userId = cursor.getString(cursor.getColumnIndex(UserDb._ID));
            String userName = cursor.getString(cursor.getColumnIndex(UserDb.NAME));
            Long registered = cursor.getLong(cursor.getColumnIndex(UserDb.REGISTERED));
            RegisteredUser registeredUser = new RegisteredUser(userName, userId, registered, null);
            registeredUsers.add(registeredUser);
        }

        ///!!! close cursor
        cursor.close();

        assertEquals(registeredUsers.size(), 1);
        assertEquals(registeredUsers.get(0).getUserName(), "Shelia Chang");


        Cursor usersDbCursor = readableConnection.query(UserDb.TABLE, null, null,
                null, null, null, null, null);


        assertEquals(usersDbCursor.getCount(), 5);

        usersDbCursor.close();

    }

    @Test
    public void getUsersFromDb() {
        SQLiteDatabase readableConnection = mSqlConnector.getReadableDatabase();
        Cursor usersDbCursor = readableConnection.query(UserDb.TABLE, null,
                null,
                null, null, null, null, null);

        assertEquals(usersDbCursor.getCount(), 0);

        usersDbCursor.close();
    }

    private RegisteredUser[] readRegisteredUsers() {
        InputStream mockedInputStream = Mocks.stream("generated.json");
        Reader reader = new InputStreamReader(mockedInputStream);

        return new Gson().fromJson(reader, RegisteredUser[].class);
    }

    private ListRegisteredUsers readRegisteredUsersList() {
        InputStream mockedInputStream = Mocks.stream("generated.json");
        Reader reader = new InputStreamReader(mockedInputStream);

        return new Gson().fromJson(reader, ListRegisteredUsers.class);
    }
}
