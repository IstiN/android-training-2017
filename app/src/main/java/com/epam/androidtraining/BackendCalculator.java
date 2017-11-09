package com.epam.androidtraining;

import android.support.annotation.WorkerThread;
import android.util.Log;

import com.epam.androidtraining.http.HttpClient;
import com.epam.androidtraining.loaders.CalculateAsyncTask;
import com.epam.androidtraining.loaders.ICalculatorListener;
import com.epam.training.backend.calculator.domain.*;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class BackendCalculator implements ICalculator {

    @Override
    public String add(final int... values) {
        final String url = new CalcApi(BuildConfig.BASE_CALC_URL).getEvaluateSumUrl(values[0], values[1]);
        final MyResponseListener listener = new MyResponseListener();
        new HttpClient().request(url, listener);
        return String.valueOf(listener.getResult().getSum());
    }

    @Override
    public String multiply(final int... values) {
        throw new UnsupportedOperationException("multiply");
    }

    @Override
    @WorkerThread
    public String evaluate(final String value) {
        final String url = new CalcApi(BuildConfig.BASE_CALC_URL).getEvaluateUrl(value);
        final MyResponseListener listener = new MyResponseListener();
        new HttpClient().request(url, listener);
        if (listener.getThrowable() != null) {
            //TODO implement error handling on UI
            throw new RuntimeException(listener.getThrowable());
        }
        Result result = listener.getResult();
        if (result.getError()!=null){
            return result.getError();
        } else {
            return result.getSum();
        }
    }

    public static class MyResponseListener implements HttpClient.ResponseListener {
        private static final String TAG = "MyResponseListener";

        private Result result;
        private Throwable mThrowable;

        @Override
        public void onResponse(final InputStream pInputStream) throws Exception {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(pInputStream);
                result = new GsonBuilder()
                        .setLenient()
                        .create().fromJson(inputStreamReader, Result.class);
            }catch (Exception e) {
                Log.d(TAG, "onResponse() called with: pInputStream = [" + pInputStream + "]");
                mThrowable = e;
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception ignored) {
                    }
                }
            }
        }

        public Throwable getThrowable() {
            return mThrowable;
        }

        @Override
        public void onError(final Throwable pThrowable) {
            mThrowable = pThrowable;
        }

        public Result getResult() {
            return result;
        }
    }
}
