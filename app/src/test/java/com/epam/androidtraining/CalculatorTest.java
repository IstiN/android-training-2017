package com.epam.androidtraining;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import static junit.framework.Assert.assertEquals;

public abstract class CalculatorTest {

    abstract ICalculator createCalculator();

    protected ICalculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = createCalculator();
    }

    @Test
    public void testAdd() {
        if (mCalculator instanceof BackendCalculator) {
            assertEquals("10", mCalculator.evaluate("5+5"));
        } else {
            assertEquals("3", mCalculator.evaluate(Matchers.anyString()));
        }
        final String result = mCalculator.add(1, 2);
        assertEquals("3", result);
    }


}