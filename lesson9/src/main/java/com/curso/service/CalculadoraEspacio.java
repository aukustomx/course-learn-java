package com.curso.service;

import com.curso.model.Indice;
import com.curso.model.Tabla;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculadoraEspacio {

    public static void main(String[] args) throws IOException {

        List<String> infoTablas = Files.readAllLines(Paths.get("/tmp/informacion-tabla.txt"));

        List<Tabla> tablas = new ArrayList<>();
        for (int i = 1; i < infoTablas.size(); i++) {
            //System.out.println(infoTablas.get(i));

            String[] infoTabla = infoTablas.get(i).split(",");
            //0- MCDT004
            //1- 750
            //2- IND MCDTOO4
            //3- 450
            //4- 0
            //5- 0

            int tracks = Integer.parseInt(infoTabla[1]);
            boolean isCompressed = infoTabla[4].equals("1");
            int compressedRatio = Integer.parseInt(infoTabla[5]);
            Indice indice = new Indice(infoTabla[2], Integer.parseInt(infoTabla[3]));

            Tabla tabla = new Tabla(infoTabla[0], tracks, indice, isCompressed, compressedRatio);
            tablas.add(tabla);

            System.out.println(tabla);
        }

        FileWriter writer = new FileWriter("/tmp/results.txt");
        for (int i = 0; i < tablas.size(); i++) {

            Tabla tabla = tablas.get(i);
            tabla.calcularEspacio();
            System.out.println(tabla);
            writer.write(tabla.getNombre() + ", " + tabla.getGb() + "\n");
        }
        writer.close();
    }
}
