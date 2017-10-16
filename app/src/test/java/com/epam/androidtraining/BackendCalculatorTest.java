package com.epam.androidtraining;

import static org.mockito.Mockito.spy;

public class BackendCalculatorTest extends CalculatorTest {

    @Override
    ICalculator createCalculator() {
        return spy(BackendCalculator.class);
    }

}
