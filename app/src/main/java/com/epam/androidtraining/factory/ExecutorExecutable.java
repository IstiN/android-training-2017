package com.epam.androidtraining.factory;

import com.epam.androidtraining.calculator.CalculationManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExecutable extends Executable{

    ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    public ExecutorExecutable(String input, CalculationManager.CalculationResultListener resultListener) {
        super(input, resultListener);
    }

    @Override
    void publishResult(String result, CalculationManager.CalculationResultListener resultListener) {
        super.publishResult(result, resultListener);
    }

    @Override
    public void execute() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //work in background
                String result = null;

                try {
                    result = CalculationManager.getInstance().getCalculator().evaluate(input);
                } catch (Exception e) {
                    publishError(e, resultListener);
                }

                publishResult(result, resultListener);

            }
        };
        mExecutorService.execute(runnable);
    }
}
