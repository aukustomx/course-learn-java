# Interfaces, clases abstractas, lectura y escritura de archivos

## Interfaces


## Clases abstractas

## Lectura de archivos
En Java existen muchas formas para leer el contenido de un archivo: *BufferedReader, Scanner, StreamTokenizer, DataInputStream, SequenceInputStream and FileChannel*.

Repasemos aquellas que aparecen desde la versión 7 de Java.
### Leer un pequeño archivo a la Java 7+

Supongamos que tenemos un archivo que contiene unas cuantas líneas de texto, y el archivo se llama `registros.txt`. El contenido del archivo es el siguiente:

05-06-2019,Juan Perez,CDMX,25
05-06-2019,Mario Martinez,CDMX,25
05-06-2019,María Lopez,CDMX,25
05-06-2019,Jesus Marin,CDMX,25
05-06-2019,Martha Garcia,CDMX,25

El codigo para leer el archivo es el siguiente:
```java
public void printFileLines(String fileFullPath) {
    Path path = Paths.get(fileFullPath);
    Files.readAllLines(path).forEach(System.out::println)
}
```
### Leer un archivo grande a la Java 7+ way
Ahora veamos cómo leer un archivo grande.

```java
public void printFileLinesContaining(String fileFullPath, String match) throws Exception {

    Path path = Paths.get(fileFullPath);

    BufferedReader reader = Files.newBufferedReader(path);
    String line = reader.readLine();

    while (null != line) {
        if (line.contains(match)) {
            System.out.println(line);
        }
        line = reader.readLine();
    }

    reader.close();
}
```
## Escritura de archivos

Así como existen muchas formas de leer el contenido de un archivo, existen otras más para escribir a un archivo: *BufferedWriter, PrintWriter, FileOutputStream, DataOutputStream, RandomAccessFile, FileChannel y las clases utilitarias que aparecierona partir de la versión 7 de Java*. En este curso, solo veremos algunas y que nos servirán para los casos más comunes. Solo ten en cuenta que puedes echar mano de aquellas que no se explican aquí, si llegaras a necesitarlo.

### BufferedWriter
```java
public void writeToFile(String filename) throws Exception {
    String str = "Hello";
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    writer.write(str);
    writer.close();
}
```

Probemos leyendo el archivo registros-grande.txt y escribiendo cada línea que comience con `"<api "` en un nuevo archivo llamado `apis.txt`

### Agregando contenido a un archivo existente

```java
public void writeToFile(String filename) throws Exception {
    String str = "World";
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
    writer.append(' ');
    writer.append(str);
    writer.close();
}
```

### Escribiendo a un archivo usando la clase utilitaria `Files`
Finalmente, revisaremos la forma en que podemos escribir a un archivo utilizando la clase utilitaria `Files`:

```java
public void writeToFile(String filename) throws Exception {
    String str = "Course Learn Java";
    Path path = Paths.get(filename);
    byte[] strToBytes = str.getBytes();
    Files.write(path, strToBytes);
    System.out.println(Files.readAllLines(path).get(0));
}

```

Hemos revisado las formar más comunes de leer y escribir archivos con Java, desde los más pequeños hasta enormes archivos. No olvides que hay más opciones de lectura y escritura que seguramente te podrán ayudar según sea tu caso. Revísalas y úsalas.

## Tarea para la clase 8
De las clases identificadas en su proyecto (tarea de la presente clase):
1. Agruparlas en paquetes
2. Generar un proyecto `maven` a partir del arquetipo `quickstart` del mismo `maven`.
3. Implementar las clases con sus atributos y comportamientos y colocarlas dentro del paquete correspondiente
4. Subir el proyecto (en código) a su cuenta de github.com antes de la clase 8.
