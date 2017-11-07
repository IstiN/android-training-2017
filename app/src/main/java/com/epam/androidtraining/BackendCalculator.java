package com.epam.androidtraining;

import android.support.annotation.WorkerThread;

import com.epam.androidtraining.http.HttpClient;
import com.epam.training.backend.calculator.domain.*;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

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
            throw new UnsupportedOperationException(listener.getThrowable());
        }
        return String.valueOf(listener.getResult().getSum());
    }

    private static class MyResponseListener implements HttpClient.ResponseListener {

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
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception ignored) {}
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
