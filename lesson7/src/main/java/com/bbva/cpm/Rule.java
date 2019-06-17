package com.bbva.cpm;

public class Rule {

    private String name;
    private String regex;

    public Rule(String name, String regex) {
        this.name = name;
        this.regex = regex;
    }

    public String getName() {
        return name;
    }

    public String getRegex() {
        return regex;
    }
}
