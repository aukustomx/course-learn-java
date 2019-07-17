package com.curso.nio2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathCreation {

    public static void main(String[] args) throws URISyntaxException, IOException {

        /*
        Path path1 = Paths.get("/tmp/prueba.txt");
        Path path2 = Paths.get("/tmp/prueba2.txt");
        Path path3 = Paths.get("d:\\changeman\\mx\\bo\\mc@\\064224\\crc\\program.cbl");

        Path path4 = Paths.get("d:", "changeman", "mx",
                "bo", "mc@", "064224", "crc", "program.cbl");
        System.out.println("La ruta es: " + path4);

        System.out.println("Separator: " + File.separator);

        //Con URIs
        Path path5 = Paths.get(new URI("file:///home/apx-transactions"));
        Path path6 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));

        FileSystem myFileSystem = FileSystems.getDefault();
        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.bbva.com"));

        FileSystem spainFileSystem = FileSystems.getFileSystem(
                new URI("ftp://username:password@ftp.spain.com:/home/user/files"));

        */

        Path base = Paths.get("/", "changeman", "mx",
                "bo", "mc@", "064224", "crc", "program.cbl");

        /*Path path7 = base.getFileName();
        System.out.println("El filename es: " + path7);
        System.out.println("El parent de base es: " + base.getParent().getParent());

        Path path8 = Paths.get("d:", "changeman", "mx",
                "bo", "mc@", "064224", "crc").getFileName();
        System.out.println("El filename es: " + path8);

        Path path9 = Paths.get("changeman", "crc", "program.cbl");
        System.out.println("El padre de la ruta 9 es: " + path9.getParent());
        */

        /*
        System.out.println("Elementos en la base: " + base.getNameCount());
        for (int i = 0; i < base.getNameCount(); i++) {
            System.out.println("    Elemento " + i + " es: " + base.getName(i));
        }
        System.out.println("El país es: " + base.getName(1));

        String knownPath = "/" + "sysview";
        String element1 = "mx";
        String element2 = "co";
        String element3 = "pe";

        Path dynamicPath = Paths.get(knownPath, element1);
        System.out.println("Ruta dinámica: " + dynamicPath);
        */
  /*
        Path withUriPath = Paths.get(new URI("file:///tmp/prueba20.txt"));
        try {
            List<String> lineas = Files.readAllLines(withUriPath);
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("El archivo no existe");
            System.out.println("Creando nuevo archivo...");
            Files.createFile(Paths.get("/tmp/prueba20.txt"));
        }

        System.out.println(Paths.get("../file.txt"));
        System.out.println(Paths.get("../file.txt").toAbsolutePath().normalize());
*/

        Path source = Paths.get("/tmp/prueba.txt");
        Path target = Paths.get("/tmp/prueba22.txt");

        boolean targetExists = Files.exists(target);
        /*if (targetExists) {
            System.out.println("Renombrando archivo existente...");
            Files.move(target, Paths.get(target.toString().concat(System.currentTimeMillis() + "")));
        }*/

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copiando archivo...");

        Files.deleteIfExists(Paths.get("/tmp/otrofile.txt"));
    }
}
