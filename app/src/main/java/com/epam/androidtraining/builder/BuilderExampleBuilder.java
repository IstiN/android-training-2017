package com.epam.androidtraining.builder;

public class BuilderExampleBuilder {
    private String first;
    private String second;
    private String additional;
    private String someDescription;

    public BuilderExampleBuilder setFirst(String first) {
        this.first = first;
        return this;
    }

    public BuilderExampleBuilder setSecond(String second) {
        this.second = second;
        return this;
    }

    public BuilderExampleBuilder setAdditional(String additional) {
        this.additional = additional;
        return this;
    }

    public BuilderExampleBuilder setSomeDescription(String someDescription) {
        this.someDescription = someDescription;
        return this;
    }

    public BuilderExample createBuilderExample() {
        return new BuilderExample(first, second, additional, someDescription);
    }
}