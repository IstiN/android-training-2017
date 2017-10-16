package com.epam.training.backend.calculator;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("s")
    private Integer sum;

    @SerializedName("e")
    private String error;

    public int getSum() {
        return sum;
    }

    public void setSum(final int pSum) {
        sum = pSum;
    }

    public String getError() {
        return error;
    }

    public void setError(final String pError) {
        error = pError;
    }
}
