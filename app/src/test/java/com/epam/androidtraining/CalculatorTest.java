package com.epam.androidtraining;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public abstract class CalculatorTest {


    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = createCalculator();
    }

    abstract ICalculator createCalculator();

    @Test
    public void testAdd() {
        assertEquals("3", mCalculator.evaluate("1+2"));

        final String result = mCalculator.add(1,2);
        assertEquals("3", result);

        doReturn("5").when(mCalculator).evaluate(Matchers.anyString());
        assertEquals("5", mCalculator.evaluate(Matchers.anyString()));
    }


}