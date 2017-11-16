package com.epam.androidtraining.factory;

import com.epam.androidtraining.calculator.CalculationManager;

public class ThreadExecutable extends Executable{
    public ThreadExecutable(String input, CalculationManager.CalculationResultListener resultListener) {
        super(input, resultListener);
    }

    @Override
    public void execute() {
        new Thread(new Runnable() {
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
        }).start();
    }
}
