package com.epam.androidtraining.factory;

import com.epam.androidtraining.calculator.CalculationManager;

public class ExecutorThreadCreator implements AbstractExecutableFactory<String, CalculationManager.CalculationResultListener> {

    @Override
    public Executable createExecutable(String input, CalculationManager.CalculationResultListener resultListener) {
        return new ThreadExecutable(input, resultListener);
    }
}
