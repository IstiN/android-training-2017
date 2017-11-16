package com.epam.androidtraining.generic;

import com.epam.androidtraining.factory.Executable;

public class GenericPair<X ,Y> {
    private X varX;
    private Y varY;

    public GenericPair(X varX, Y varY) {
        this.varX = varX;
        this.varY = varY;
    }

    public X getVarX() {
        return varX;
    }

    public void setVarX(X varX) {
        this.varX = varX;
    }

    public Y getVarY() {
        return varY;
    }

    public void setVarY(Y varY) {
        this.varY = varY;
    }
}
