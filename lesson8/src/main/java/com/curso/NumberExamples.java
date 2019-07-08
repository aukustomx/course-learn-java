package com.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class NumberExamples {

    public static void main(String[] args) {

        byte b = 1;
        short s = 123;
        int i = 343434324;
        long l = 2034343243243L;

        Byte bw = new Byte(b);
        Integer iw = new Integer(i);

        int[] enteros = {1, 2, 3, 4, 5};
        List<Integer> integers = new ArrayList<>();

        byte b1 = bw.byteValue();

        Integer iw2 = i;
        int i2 = iw2;


        double p1 = 1.56;
        double p2 = 0.5;
        double p3 = 2.3;
        double p4 = 1.56;
        double p5 = 1.0;

        List<Double> promedios = Arrays.asList(p1, p2, p3, p4, p5);
        OptionalDouble average = promedios.stream()
                .mapToDouble(x -> x.doubleValue())
                .average();

        System.out.println(average.getAsDouble());

        printfAndFormat();
    }

    public static void printfAndFormat() {

        float floatVar = 2.3f;
        int intVar = 25;
        String stringVar = "hola!";

        System.out.format("The value of " + "the float variable is " +
                "%f, while the value of the " + "integer variable is %d, " +
                "and the string is %s", floatVar, intVar, stringVar);
    }


}
