package com.epam.androidtraining.composite;

import android.util.Log;

class Ellipse implements Graphic {

    public static final String TAG = Ellipse.class.getSimpleName();

    //Prints the graphic.
    public void draw() {
        Log.i(TAG, "draw: Ellipse");
    }
}

