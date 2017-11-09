package com.epam.androidtraining.loaders;

import android.os.AsyncTask;
import android.util.Log;

import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.http.HttpClient;
import com.epam.training.backend.calculator.domain.Result;

public class CalculateAsyncTask extends AsyncTask<String, AsyncTask.Status, Result> {

    private static final String TAG = CalculateAsyncTask.class.getSimpleName();
    private ICalculatorListener<Result> mCalculatorListener;
    private BackendCalculator.MyResponseListener mResponseListener;

    public CalculateAsyncTask(BackendCalculator.MyResponseListener responseListener, ICalculatorListener<Result> listener){
        super();

        mCalculatorListener = listener;
        mResponseListener = responseListener;
    }

    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute");
        mCalculatorListener.onStart();
    }

    @Override
    protected Result doInBackground(String... var1) {
        Log.i(TAG, "doInBackground");
        final BackendCalculator.MyResponseListener listener = new BackendCalculator.MyResponseListener();
        try {
            new HttpClient().request(var1[0], listener);
            return mResponseListener.getResult();
        } catch (Exception e) {
            mCalculatorListener.onError(e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Result result) {
        mCalculatorListener.onSuccess(result);
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
