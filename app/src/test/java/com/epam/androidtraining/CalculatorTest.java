package com.epam.androidtraining;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public abstract class CalculatorTest {


    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = createCalculator();
    }

    abstract ICalculator createCalculator();

    @Test
    public void testAdd() {
        assertEquals("3", mCalculator.evaluate(Matchers.anyString()));

        final String result = mCalculator.add(1,2);
        assertEquals("3", result);

        when(mCalculator.evaluate(Matchers.anyString())).thenReturn("5");
        assertEquals("5", mCalculator.evaluate(Matchers.anyString()));
    }


}