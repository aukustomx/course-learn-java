package com.curso;

public class Palindromo {

    public static void main(String[] args) {

        String phrase = "sometamosomatemos";
        int length = phrase.length();

        //String inverted = "";
        StringBuilder inverted = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {

            char c = phrase.charAt(i);
            inverted.append(c);
        }

        if (phrase.equals(inverted.toString())) {
            System.out.format("Las cadenas %s y %s son iguales", phrase, inverted);
        } else {
            System.out.format("Las cadenas %s y %s no son iguales", phrase, inverted);
        }
    }
}
