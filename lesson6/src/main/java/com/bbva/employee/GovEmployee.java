package com.bbva.employee;

public class GovEmployee extends Employee implements MailEmployee {

    public GovEmployee(int aBonus) {
        super(aBonus);
    }

    @Override
    public int cobrarBono() {
        System.out.println("Como empleado del gobierno mi bono es: " + getBono());
        return getBono();
    }
}
