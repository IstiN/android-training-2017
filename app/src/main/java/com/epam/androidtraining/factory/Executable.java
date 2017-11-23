package com.epam.androidtraining.factory;

import android.os.Handler;
import android.os.Looper;

import com.epam.androidtraining.calculator.CalculationManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Executable {

    String input;
    CalculationManager.CalculationResultListener resultListener;

    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public Executable(String input, CalculationManager.CalculationResultListener resultListener) {
        this.input = input;
        this.resultListener = resultListener;
    }

    public abstract void execute();

    void publishResult(final String result, final CalculationManager.CalculationResultListener resultListener) {
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resultListener.onSuccess(result);
            }
        }, 1000);//delay is only for demonstration
    }

    void publishError(final Exception e, final CalculationManager.CalculationResultListener resultListener) {
        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                resultListener.onError(e);
            }
        });
    }
}
