package com.epam.androidtraining;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.epam.androidtraining.http.HttpClient;
import com.epam.androidtraining.http.IHttpClient;
import com.epam.androidtraining.json.IUsersList;
import com.epam.androidtraining.json.UserGson;
import com.epam.androidtraining.json.UsersListParserFactory;

import java.io.InputStream;
import java.util.List;

/**
 * Created by evgen on 12.10.2017.
 */

public class UserListLoader extends AsyncTask<Context, Void, String> {

    public static final String NO_DATA = "No data";
    private IUsersList userListWithObject;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        final UsersListParserFactory usersListParserFactory = new UsersListParserFactory();
        IHttpClient httpClient = new HttpClient();

        userListWithObject = null;

        httpClient.request(Api.USER_URL, new HttpClient.ResponseListener() {
            @Override
            public void onResponse(InputStream pInputStream) {
                try {
                    userListWithObject = usersListParserFactory.createParserForResponceWithObject(pInputStream).parse();
                } catch (final Exception e) {
                    onError(e);
                }

            }

            @Override
            public void onError(final Throwable pThrowable) {

            }
        });

        context = params[0];

        if (userListWithObject == null) {
            return NO_DATA;
        }

        List<UserGson> usersList = userListWithObject.getUsersList();

        if (usersList == null || usersList.isEmpty()) {
            return NO_DATA;
        }

        return usersList.get(usersList.size() -1).getName();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

}
