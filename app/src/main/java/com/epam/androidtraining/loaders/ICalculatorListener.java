package com.epam.androidtraining.loaders;

public interface ICalculatorListener<T> {

    void onStart();

    void onSuccess(T result);

    void onError(Exception e);

}
