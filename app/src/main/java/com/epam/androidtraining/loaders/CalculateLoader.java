package com.epam.androidtraining.loaders;

import android.content.Context;
import android.content.Loader;

import com.epam.training.backend.calculator.domain.Result;

public class CalculateLoader extends Loader<Result> {

    private ICalculatorListener<Result> mListener;

    public CalculateLoader(Context context) {
        super(context);
    }

    public CalculateLoader(Context context, ICalculatorListener<Result> listener) {
        super(context);

        mListener = listener;
    }

    @Override
    protected void onStartLoading(){
//        mListener.onStart();
    }

    @Override
    protected void onStopLoading(){

    }
}
