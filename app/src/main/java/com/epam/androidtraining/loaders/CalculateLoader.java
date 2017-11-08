package com.epam.androidtraining.loaders;

import android.content.Context;
import android.content.Loader;

import com.epam.training.backend.calculator.domain.Result;

public class CalculateLoader extends Loader<Result> {

    public CalculateLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading(){

    }

    @Override
    protected void onStopLoading(){

    }


}
