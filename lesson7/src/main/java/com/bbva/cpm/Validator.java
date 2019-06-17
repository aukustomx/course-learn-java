package com.bbva.cpm;

import java.util.List;

public interface Validator {

    boolean validateExpression(String expression);
    void loadRules(List<Rule> rules);
}
