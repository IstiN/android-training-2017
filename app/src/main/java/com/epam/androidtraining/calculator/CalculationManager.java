package com.epam.androidtraining.calculator;


import android.os.Handler;
import android.os.Looper;

import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.ICalculator;
import com.epam.androidtraining.loaders.CalculatorAsyncTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculationManager {
    private static CalculationManager sInstance;
    private final ICalculator mCalculator;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private CalculationManager() {
        mCalculator = new BackendCalculator();
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
                    result = mCalculator.evaluate(input);
                } catch (Exception e) {
                    publishError(e, resultListener);
                }
                publishResult(result, resultListener);

            }
        };
        mExecutorService.execute(runnable);
    }

    private void loadWithThread(final String input, final CalculationResultListener resultListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //work in background
                String result = null;
                try {
                    result = mCalculator.evaluate(input);
                } catch (Exception e) {
                    publishError(e, resultListener);
                }
                publishResult(result, resultListener);

            }
        }).start();
    }

    private void loadWithAsyncTask(String input, final CalculationResultListener resultListener) {
        new CalculatorAsyncTask(mCalculator, resultListener).executeOnExecutor(mExecutorService, input);
    }

    private void publishResult(final String result, final CalculationResultListener resultListener) {
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resultListener.onSuccess(result);
            }
        }, 2000);//delay is only for demonstration
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
