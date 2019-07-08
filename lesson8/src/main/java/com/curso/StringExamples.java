package com.curso;

public class StringExamples {

    public static void main(String[] args) {

        String name1 = "Clau";
        String name2 = new String("Clau");

        char[] charName3 = {'M', 'a', 'r', 'c', 'o'};
        String name3 = new String(charName3);

        String concatName = name1.concat(name2);

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(concatName);
    }
}
