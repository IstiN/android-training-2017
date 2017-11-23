package com.epam.training.backend.calculator.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CalcApi {

    private static final String CALC = "calc?input=";

    private String mBasePath;

    public CalcApi(final String pBasePath) {
        if (pBasePath.charAt(pBasePath.length() - 1) == '/') {
            mBasePath = pBasePath;
        } else {
            mBasePath = pBasePath + "/";
        }
    }

    public String getEvaluateSumUrl(final int a, final int b) {
        return getEvaluateUrl(a + "+" + b);
    }

    public String getEvaluateUrl(String input) {
        try {
            return mBasePath + CALC + URLEncoder.encode(input, "UTF-8");
        } catch (final UnsupportedEncodingException pE) {
            throw new IllegalStateException(pE);
        }
    }

}
