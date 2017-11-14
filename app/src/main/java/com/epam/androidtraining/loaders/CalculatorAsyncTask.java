package com.epam.androidtraining.loaders;

import android.os.AsyncTask;

import com.epam.androidtraining.ICalculator;
import com.epam.androidtraining.calculator.CalculationManager;

public class CalculatorAsyncTask extends AsyncTask<String, Void, Object> {

    private final CalculationManager.CalculationResultListener mResultListener;
    private final ICalculator mCalculator;

    public CalculatorAsyncTask(final ICalculator pCalculator, final CalculationManager.CalculationResultListener pResultListener) {
        mCalculator = pCalculator;
        mResultListener = pResultListener;
    }


    @Override
    protected Object doInBackground(String... strings) {
        try {
            return mCalculator.evaluate(strings[0]);
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object result) {
        if (result instanceof String) {
            mResultListener.onSuccess((String) result);
        } else if (result instanceof Throwable) {
            Throwable throwable = (Throwable) result;
            mResultListener.onError(throwable);
        } else {
            mResultListener.onError(new IllegalStateException("Unknown result"));
        }
    }
}
