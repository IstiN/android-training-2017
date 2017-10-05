package com.epam.androidtraining;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class CalculatorTest {


    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = spy(Calculator.class);
//        mCalculator = new Calculator();
    }

    @Test
    public void testAdd() {
        when(mCalculator.evaluate(Matchers.anyString())).thenReturn("4");
        String result = mCalculator.add(1,2);

        assertEquals(result, "3");
        assertEquals(mCalculator.evaluate(Matchers.anyString()), "5");
    }


}