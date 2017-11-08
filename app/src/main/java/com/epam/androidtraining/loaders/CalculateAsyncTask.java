package com.epam.androidtraining.loaders;

import android.os.AsyncTask;
import android.util.Log;

import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.http.HttpClient;
import com.epam.training.backend.calculator.domain.Result;

public class CalculateAsyncTask extends AsyncTask<String, AsyncTask.Status, Result> {

    private static final String TAG = CalculateAsyncTask.class.getSimpleName();
    private BackendCalculator.MyResponseListener myResponseListener;

    public CalculateAsyncTask(BackendCalculator.MyResponseListener listener){
        super();
        myResponseListener = listener;
    }

    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute");
    }

    @Override
    protected Result doInBackground(String... var1) {
        Log.i(TAG, "doInBackground");
        new HttpClient().request(var1[0], myResponseListener);
        return myResponseListener.getResult();
    }

    @Override
    protected void onPostExecute(Result result) {
        if (result != null) {
            Log.i(TAG, "onPostExecute" + String.valueOf(result.getSum()));

            Log.i(TAG, "onPostExecute" + String.valueOf(result.getError()));
        }
    }

    @Override
    protected void onProgressUpdate(Status... values) {
        Log.i(TAG, "onProgressUpdate" + values[0]);
    }

    @Override
    protected void onCancelled() {
      //  throw new RuntimeException("Stub!");
    }

}
