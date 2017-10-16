package com.epam.androidtraining;

import static org.mockito.Mockito.spy;

public class LocalCalculatorTest extends CalculatorTest {

    @Override
    ICalculator createCalculator() {
        return spy(Calculator.class);
    }

}
