package com.epam.androidtraining.calculator;


import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.ICalculator;
import com.epam.androidtraining.loaders.CalculateAsyncTask;
import com.epam.androidtraining.loaders.ICalculatorListener;
import com.epam.training.backend.calculator.domain.Result;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculationManager {
    private static CalculationManager sInstance;
    private final ICalculator calculator;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private CalculationManager() {
        calculator = new BackendCalculator();
    }

    public static CalculationManager getInstance() {
        if (sInstance == null) {
            synchronized (CalculationManager.class) {
                sInstance = new CalculationManager();
            }
        }
        return sInstance;
    }

    public void calculate(final String input, final CalculationResultListener resultListener) {
        // loadWithThread(input, resultListener);

        // loadWithAsyncTask(input, resultListener);

        loadWithExecutor(input, resultListener);
    }

    private void loadWithExecutor(final String input, final CalculationResultListener resultListener) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //work in background
                String result = null;
                try {
                    result = calculator.evaluate(input);
                } catch (Exception e) {
                    publishError(e, resultListener);
                }
                publishResult(result, resultListener);

            }
        };
        executorService.execute(runnable);
    }

    private void loadWithThread(final String input, final CalculationResultListener resultListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //work in background
                String result = null;
                try {
                    result = calculator.evaluate(input);
                } catch (Exception e) {
                    publishError(e, resultListener);
                }
                publishResult(result, resultListener);

            }
        }).start();
    }

    private void loadWithAsyncTask(String input, final CalculationResultListener resultListener) {
        new AsyncTask<String, Void, String>() {

            protected void onPreExecute() {

            }


            @Override
            protected String doInBackground(String... strings) {
                try {
                    return calculator.evaluate(strings[0]);
                } catch (Exception e) {
                    publishError(e, resultListener);
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String result) {
                if (result != null) {
                    publishResult(result, resultListener);
                }
            }
        }.executeOnExecutor(Executors.newFixedThreadPool(5), input);
    }

    private void publishResult(final String result, final CalculationResultListener resultListener) {
       uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resultListener.onSuccess(result);
            }
        }, 2000);
      //  resultListener.onSuccess(result);
    }

    private void publishError(final Exception e, final CalculationResultListener resultListener) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                resultListener.onError(e);
            }
        });
    }

    public interface CalculationResultListener {

        void onSuccess(String result);

        void onError(Throwable throwable);
    }
}
