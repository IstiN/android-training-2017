package com.epam.androidtraining;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(RobolectricTestRunner.class)
@Config(
    constants = BuildConfig.class,
    sdk = Constants.SDK_VERSION
)
public class CalculatorActivityTest {

    private ActivityController<CalculatorActivity> activityController;

    @Before
    public void init() {
        activityController = Robolectric.buildActivity(CalculatorActivity.class);
        String input = "(1+3)/2)(";


    }

    @Test
    public void testCalculator() {
        activityController.create();
        activityController.start();
        activityController.resume();


        CalculatorActivity calculatorActivity = activityController.get();
        boolean isCalculateButtonEnabled = calculatorActivity.findViewById(R.id.calculate_button).isEnabled();
        assertEquals(isCalculateButtonEnabled, false);
        assertFalse(isCalculateButtonEnabled);

        //TODO add additional checks
    }

    @After
    public void destroy() {

    }
}