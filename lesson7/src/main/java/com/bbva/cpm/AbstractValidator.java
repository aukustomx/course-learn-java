package com.bbva.cpm;

public abstract class AbstractValidator implements Validator {

    public abstract int extract(int a, int b);

    public int sum(int a, int b) {
        return a + b;
    }
}
