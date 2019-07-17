package com.curso.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathComponentsExample {

    public static void main(String[] args) {

//        printPathComponentsInfo(Paths.get("/", "reports", "feb", "report.txt"));
//        System.out.println();
//        printPathComponentsInfo(Paths.get("reports/feb/report.txt"));

        Path path = Paths.get("documents/important/monthly/report1.txt");
        System.out.println("Paths is: " + path);

        System.out.println("Subpath from 0 to 4 is: " + path.subpath(0, 4));
        System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
        System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
        System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));

    }

    public static void printPathComponentsInfo(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println("Root is: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println("    Current parent is: " + currentPath);
        }
    }
}
