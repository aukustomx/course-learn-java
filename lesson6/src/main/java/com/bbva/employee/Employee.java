package com.bbva.employee;

public class Employee {

    private int bono;

    public Employee(int aBonus) {
        this.bono = aBonus;
    }

    public int cobrarBono() {
        return 0;
    }

    public int getBono() {
        return bono;
    }
}
