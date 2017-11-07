package com.epam.training.backend.calculator.domain;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("s")
    private String sum;

    @SerializedName("e")
    private String error;

    public String getSum() {
        return sum;
    }

    public void setSum(final String pSum) {
        sum = pSum;
    }

    public String getError() {
        return error;
    }

    public void setError(final String pError) {
        error = pError;
    }
}
