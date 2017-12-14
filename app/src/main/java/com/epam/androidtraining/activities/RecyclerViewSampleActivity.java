package com.epam.androidtraining.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.epam.androidtraining.R;
import com.epam.androidtraining.adapter.MessageCursorRecyclerAdapter;
import com.epam.androidtraining.db.utils.DbUtils;
import com.epam.androidtraining.loaders.MessagesLoader;
import com.epam.androidtraining.model.MessageModel;

public class RecyclerViewSampleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String TAG = "RecyclerViewSampleActiv";
    public static final int DB_LOADER_ID = 0;
    public static final int MESSAGES_LOADER_ID = 1;
    private MessageCursorRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(getLayoutId());


        final RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MessageCursorRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);

        getSupportLoaderManager().initLoader(MESSAGES_LOADER_ID, null, new LoaderManager.LoaderCallbacks<Boolean>() {
            @Override
            public Loader<Boolean> onCreateLoader(int id, Bundle args) {
                Log.d(TAG, "onCreateLoader() called with: id = [" + id + "], args = [" + args + "]");
                return new MessagesLoader(RecyclerViewSampleActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<Boolean> loader, Boolean data) {
                Log.d(TAG, "onLoadFinished() called with: loader = [" + loader + "], data = [" + data + "]");
                initLoadFromDb();
            }

            @Override
            public void onLoaderReset(Loader<Boolean> loader) {
                Log.d(TAG, "onLoaderReset() called with: loader = [" + loader + "]");
            }
        });
    }

    private void initLoadFromDb() {
        getSupportLoaderManager().initLoader(DB_LOADER_ID, null, this);
    }

    private @LayoutRes
    int getLayoutId() {
        return R.layout.activity_recyclerview_sample;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.d(TAG, "onCreateLoader() called with: id = [" + id + "], args = [" + args + "]");
        return new CursorLoader(this, DbUtils.getTableUri(MessageModel.MessagesDb.class), null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.d(TAG, "onLoadFinished() called with: loader = [" + loader + "], data = [" + data + "]");
        adapter.setItems(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.d(TAG, "onLoaderReset() called with: loader = [" + loader + "]");
        adapter.release();
    }
}
