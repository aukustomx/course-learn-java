package com.bbva.cpm;

import java.util.List;

public class SelectValidator implements Validator {

    private List<Rule> rules;

    @Override
    public boolean validateExpression(final String expression) {
        return rules.stream()
                .anyMatch(r -> expression.toLowerCase().contains(r.getRegex()));
    }

    @Override
    public void loadRules(List<Rule> rules) {
        this.rules = rules;
    }
}
