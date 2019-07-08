package com.curso;

public class SubstringExample {

    public static void main(String[] args) {

        String memberLine = "MEMBER NAME MDFT001";
        String programLine1 = "02/07/2019|MDFT001|A|35|SQL|DB2|SELECT * FROM USERS";
        String programLine2 = "02/07/2019|MDFT002|B|02|SQL|MYS|SELECT * FROM CLIENTS";

        String[] mlArray = memberLine.split(" ");
        String programName = mlArray[2];
        System.out.println("El programName es: " + programName);

        String[] otherMLArray = memberLine.split("MEMBER NAME");
        System.out.println("Numero de elementos: " + otherMLArray.length);
        System.out.println("El otro programName es: " + otherMLArray[1].trim());

        String[] plArray = programLine1.split("\\|");
        System.out.println("PL items: " + plArray.length);
        String query1 = plArray[6];
        System.out.println(query1);

        String substring1 = programLine2.substring(11);
        System.out.println("substring1: " + substring1);

        String substring2 = programLine2.substring(11, 18);
        System.out.println("substring1: " + substring2);

        String poema = "En la mañana sale el SoL";
        boolean containsSun = poema.toUpperCase().contains("SOL");
        System.out.println("El poema contiene la palabra sol: " + containsSun);

    }
}
