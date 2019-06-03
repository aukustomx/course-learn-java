package com.bbva.employee;

public class BankEmployee extends Employee {

    public BankEmployee(int aBonus) {
        super(aBonus);
    }

    @Override
    public int cobrarBono() {
        System.out.println("Como empleado de BBVA mi bono es: " + getBono());
        return getBono();
    }
}
