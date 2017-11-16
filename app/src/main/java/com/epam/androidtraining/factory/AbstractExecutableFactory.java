package com.epam.androidtraining.factory;

import com.epam.androidtraining.calculator.CalculationManager;

public interface AbstractExecutableFactory<T, Y> {
    Executable createExecutable(T input, Y listener);
}
