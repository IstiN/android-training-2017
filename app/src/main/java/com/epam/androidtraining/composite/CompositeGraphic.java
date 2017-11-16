package com.epam.androidtraining.composite;

import java.util.ArrayList;
import java.util.List;

class CompositeGraphic implements Graphic {

    //Collection of child graphics.
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();

    //Prints the graphic.
    public void draw() {
        for (Graphic graphic : mChildGraphics) {
            graphic.draw();
        }
    }

    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }

    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
    }

}

