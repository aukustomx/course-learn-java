package com.bbva.employee;

public class EmployeeApplication {

    public static void main(String[] args) {

        Employee employee = new Employee(5);
        GovEmployee govEmployee = new GovEmployee(10_000);
        PepsicoEmployee pepsicoEmployee = new PepsicoEmployee(15_000);
        BbvaEmployee bbvaEmployee = new BbvaEmployee(20_000);

        System.out.println(employee.cobrarBono());
        System.out.println(govEmployee.cobrarBono());
        System.out.println(pepsicoEmployee.cobrarBono());
        System.out.println(bbvaEmployee.cobrarBono());

        Employee poliGovEmp = govEmployee;
        MailEmployee postalEmployee = govEmployee;

        printType(employee);
        printType(govEmployee);
        printType(pepsicoEmployee);
        printType(bbvaEmployee);
    }

    public static void printType(Employee emp) {
        System.out.println(emp.getClass().getName());
    }
}
