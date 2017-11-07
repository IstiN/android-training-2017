package com.epam.androidtraining.calculator;


import com.epam.androidtraining.BackendCalculator;
import com.epam.androidtraining.ICalculator;

public class CalculationManager {
    private static CalculationManager sInstance;
    private final ICalculator calculator;

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

    public void calculate(String input, CalculationResultListener resultListener) {
        String result = calculator.evaluate(input);
        resultListener.onSuccess(result);
    }

    public interface CalculationResultListener {

        void onSuccess(String result);

        void onError(Throwable throwable);
    }
}
