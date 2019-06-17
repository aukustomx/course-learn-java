package com.bbva.cpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidatorApp {

    public static void main(String[] args) {

        Rule selectRule = new Rule("Sentencia select", "select");
        List<Rule> rules = List.of(selectRule);

        Validator selectValidator = new SelectValidator();
        selectValidator.loadRules(rules);
        boolean isValid = selectValidator.validateExpression("SELECCIONAR * FROM USERS WHERE ID='21'");
        boolean isValid2 = selectValidator.validateExpression("SELECT * FROM USERS WHERE ID='21'");

        System.out.println("La expresión1 es válida? " + isValid);
        System.out.println("La expresión2 es válida? " + isValid2);
    }
}
