package com.epam.androidtraining;

import com.epam.androidtraining.loaders.ICalculatorListener;
import com.epam.training.backend.calculator.domain.Result;

public interface ICalculator {

    String add(int... values);

    String multiply(int... values);

    String evaluate(String value);
}
