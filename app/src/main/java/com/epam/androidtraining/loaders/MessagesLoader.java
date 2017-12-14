package com.epam.androidtraining.loaders;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import com.epam.androidtraining.db.utils.DbUtils;
import com.epam.androidtraining.model.MessageModel;

import java.util.ArrayList;
import java.util.List;


public class MessagesLoader extends AsyncTaskLoader<Boolean> {
    private static final String TAG = "MessagesLoader";

    public MessagesLoader(Context context) {
        super(context);
        forceLoad();
    }

    @Override
    public Boolean loadInBackground() {
        Log.d(TAG, "loadInBackground() called");
        ContentResolver contentResolver = getContext().getContentResolver();
        Uri uri = DbUtils.getTableUri(MessageModel.MessagesDb.class);
        Cursor query = contentResolver.query(uri, null, null, null, null);
        if (query == null || query.getCount() == 0) {
            Log.d(TAG, "loadInBackground: no data");
            List<MessageModel> data = createData();

            ContentValues[] values = new ContentValues[data.size()];

            for (int i = 0; i < data.size(); i++) {
                values[i] = data.get(i).toContentValues();
            }

            int count = contentResolver.bulkInsert(uri, values);
            Log.d(TAG, "loadInBackground() inserted: " + count);

        }
        if (query != null) {
            query.close();
        }

        return true;
    }

    private List<MessageModel> createData() {
        List<MessageModel> messageList = new ArrayList<>();

        String[] urls = {"http://www.petmd.com/sites/default/files/scared-kitten-shutterstock_191443322.jpg",
                "http://r.ddmcdn.com/s_f/o_1/cx_0/cy_0/cw_300/ch_300/w_300/APL/uploads/2014/10/kitten-cuteness300.jpg",
                "https://cmeimg-a.akamaihd.net/640/clsd/getty/c64f76dc20c246ca88ee180fe4b4b781",
                "http://r.ddmcdn.com/s_f/o_1/cx_462/cy_245/cw_1349/ch_1349/w_720/APL/uploads/2015/06/caturday-shutterstock_149320799.jpg",
                "https://vetstreet.brightspotcdn.com/dims4/default/a1a90c7/2147483647/thumbnail/180x180/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F0d%2Ff2e4c0b3a611e092fe0050568d634f%2Ffile%2Fhub-cats-senior.jpg",
                "https://media.boingboing.net/wp-content/uploads/2017/03/surprised-cat-04.jpg",
                "http://cdn1-www.cattime.com/assets/uploads/gallery/persian-cats-and-kittens/persian-cats-and-kittens-1.jpg"};
        for (int i = 1; i < urls.length; i++) {

            messageList.add(new MessageModel("Hello, Recycler View", urls[i]));
        }
        return messageList;
    }
}
