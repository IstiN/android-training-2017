package com.epam.androidtraining.builder;

public class BuilderExample implements Cloneable {
    String first;
    String second;
    String additional;
    String someDescription;

    public BuilderExample(String first, String second, String additional, String someDescription) {
        this.first = first;
        this.second = second;
        this.additional = additional;
        this.someDescription = someDescription;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
