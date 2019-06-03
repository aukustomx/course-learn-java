package com.bbva.employee;

public class SodasEmployee extends Employee {

    public SodasEmployee(int aBonus) {
        super(aBonus);
    }

    @Override
    public int cobrarBono() {
        System.out.println("Como empleado de pepsico mi bono es: " + getBono());
        return getBono();
    }
}
