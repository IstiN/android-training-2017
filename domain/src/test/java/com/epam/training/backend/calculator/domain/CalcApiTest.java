package com.epam.training.backend.calculator.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcApiTest {

    private static final String BASE_PATH = "some.domain.com";
    private CalcApi mCalcApi;

    @Before
    public void setUp() throws Exception {
        mCalcApi = new CalcApi(BASE_PATH);
    }

    @Test
    public void calculateSum() throws Exception {
        assertEquals(BASE_PATH + "/" + "calc?input=1%2B15", mCalcApi.getEvaluateSumUrl(1, 15));
    }

    @Test
    public void evaluate() throws Exception {
        assertEquals(BASE_PATH + "/" + "calc?input=I%27m+lucky", mCalcApi.getEvaluateUrl("I'm lucky"));
    }

}