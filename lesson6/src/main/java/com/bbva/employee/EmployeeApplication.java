package com.bbva.employee;

public class EmployeeApplication {

    public static void main(String[] args) {

        Employee employee = new Employee(5);
        GovEmployee govEmployee = new GovEmployee(10_000);
        SodasEmployee sodasEmployee = new SodasEmployee(15_000);
        BankEmployee bankEmployee = new BankEmployee(20_000);

        System.out.print(employee.cobrarBono());
        System.out.print(govEmployee.cobrarBono());
        System.out.print(sodasEmployee.cobrarBono());
        System.out.print(bankEmployee.cobrarBono());

        printType(employee);
        printType(govEmployee);
        printType(sodasEmployee);
        printType(bankEmployee);

        //Creating Employee subclases object using Employee references
        Employee empl2 = new Employee(5);
        Employee gov2 = new GovEmployee(10_000);
        Employee sodas2 = new SodasEmployee(15_000);
        Employee bank2 = new BankEmployee(20_000);

        Employee[] employees = new Employee[4];
        employees[0] = empl2;
        employees[1] = gov2;
        employees[2] = sodas2;
        employees[3] = bank2;

        System.out.println("Same reference type, different instance type");
        System.out.println();
        for (Employee emp : employees) {
            System.out.println(emp.getClass().getName() + " bonus: " + emp.getBono());
        }
    }

    public static void printType(Employee emp) {
        System.out.println(emp.getClass().getName());
    }
}
