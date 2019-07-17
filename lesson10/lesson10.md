# NIO2 Manejo de archivos y directorios

## Path interface
Es el punto de entrada al API de NIO2
Es una ruta jerarquica de un aarchivo o directorio en el file system
Es un reemplazo de la clase `java.io.File`
Puede ser una ruta absoluta o relativa en el FS
Podemos ver un directorio como si fuera un archivo puesto que se almacena en el FS como tal
Soporta links simbólicos. Crear, detectar y navegar
Los links simbólicos son transparentes al usuario

## The Paths factory app
Podemos crear `Path`s utilizando los métodos estáticos de la clase `Paths`. 
Distinguir entre los nombres `Path` y `Paths`

## Why is Path an interfaces?
Esto permite que el detalle específico de cada sistema lo maneje la JVM. Es decir, en código Java veremos lo mismo, pero al ejecutar dicho código, es la JVM la que determina cómo crearlo por ejemplo si es Windows, Linux, MacOS, Unix, etc.
Maximiza la portabilidad entre plataformas

## The java.nio.file.Files helper class
Esta clase contiene operaciones para manipulación de objetos/instancias `Path`.
Helper vs Factory classes.

## How to create `Path`s objects
La forma más simple de crear objetos `Path` es usando la clase Paths. 
Para obtener la referencia a un directorio o archivo en el fs podemos usar `Paths.get(String)`
```java
Path path1 = Paths.get("pandas/cuddly.png"); //En el directorio actual
Path path2 = Paths.get("c:\\zooinfo\\nov\\employees.txt"); //Absoluta en Windows
Path path3 = Paths.get("/home/apx-transactions"); //Absoluta en Linux/Mac/Unix
```
Las rutas, dependiendo del file system, pueden considerarse relativas en uno y absolutas en otro y viceversa.

La clase Paths tiene un método que recibe un varargs de String. Este puede ser utilizado para resolver el problema de los slashes


```java
Path path1 = Paths.get("pandas", "cuddly.png"); 
Path path2 = Paths.get("c:", "zooinfo", "nov", "employees.txt");
Path path3 = Paths.get("/", "home", "apx-transactions");
```
Esta versión es más robusta que escribir la ruta como una sola cadena, en el sentido que esta inserta el separador apropiado por ti.

El método get() de la clase Paths tiene otra forma. Puede usarse pasándole una URI. Un Uniform resource identifier es una cadena de caracteres que indica el tipo de recurso. Comienza con un schema que indica el tipo de recurso:
* file://
* http://
* https://
* ftp://
* etc


```java
Path path1 = Paths.get(new URI("file://pandas/cuddly.png")); //Genera una excepción en runtime. 
Path path2 = Paths.get(new URI("file.///c:/zooinfo/nov/employees.txt"));
Path path3 = Paths.get(new URI("file:///home/apx-transactions));
```
Podemos utilizar URIs para recursos locales y de la red.
Una URI debe ser una ruta absoluta en tiempo de ejecución.
Una URI tiene un método `isAbsolute()` que valida si la URI tiene un schema y no si la ruta es absoluta.

Ejemplos de URIs que tal vez no utilicen pero que existen son:

```java
Path path4 = Paths.get(new URI("http://www.bbva.com")); 
Path path5 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
```

El contructor new URI lanzará una checked exception que deberá manejarse en cualquier aplicación que utilice esta funcionalidad.

Un `Path` tiene un método llamado toUri(), que devuelve la ruta en su forma de URI.
```java
Path path6 = Paths.get(new URI("http://www.bbva.com"));
URI uri6 = path6.toUri();
```

## Accessing the underlying FileSytem object

Podemos crear `Path`s con el método getPath() de la clase FileSystem. FileSystem tiene un constructor protegido, así que utilizamos la clase fábrica FileSystems para obtener una instancia de FileSystem, como sigue:
```java
Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
Path path2 = FileSystems.getDefault().getPath("c", "zooinfo", "nov", "employees.txt");
Path path3 = FileSystems.getDefault().getPath("/home/apx-transactions");
```
Este código hace exactamente lo mismo que los ejemplos anteriores.

Si necesitamos acceder frecuentemente a un FileSystem, NIO2 ofrece la capacidad de obetener dicho FS de la siguiente forma:

```java
FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.bbva.com"));
Path path = fileSystem.getPath("aviso-de-privacidad.txt");
```
Esto es útil cuando necesitamos crear con frecuencia objetos Path de un filesystem remoto. Así que podemos crear aplicaciones que manejen o manipulen archivos y directorios de nuestros archivos locales, pero podemos también construir aplicaciones más complejas que hagan referencia a sistemas de archivos externos.

## Working with legacy File class instances
Antes de NIO y NIO2, Java utilizaba la clase javs.io.File. Así que por compatibilidad, Path y File tienen métodos para convertir uno en otro.
```java
File file = new File("pandas/cuddly.png");
Path path = file.toPath();


Path path = Paths.get("cuddly.png");
File file = path.toFile();
```

Aunque esta flexibilidad está permitida, se recomienda utilizar el API de Path, pues ofrece más características, soporta varios filesystems y links simbólicos.

## What can we do with Paths and Files
NIO2 ofrece una amplia variedad de métodos y clases que operan sobre objetos `Path`; muchos más de los que el API java.io ofrece.

Hay que tener presente que un Path no es un archivo como tal en el filesystem, es una representación  de la localización del archivo en el filesystem. Podemos operar sobre un Path o Paths aunque el archivo o directorio real no exista en el FS. Pero hay operaciones sobre objetos Paths que requieren que el archivo exista, por ejemplo Path.toRealPath(); si el archivo no existiera, esto lanza una checked exception.

## Optional arguments in Path operations
Muchos de los métodos del API NIO2 reciben parámetros opcionales en forma de varargs.
* NOFOLLOW_LINKS   - Operaciones sobre los links simbólicos como tal y no en el destino al que apuntan
* FOLLOW_LINKS     - Si los encuentra, atraviesa los links simbólicos.
* COPY_ATTRIBUTES  - Copia los metadatos de un archivo en su copia.
* REPLACE_EXISTING - Si el destino existe y se provee la bandera, será reemplazado. Si no se provee la bandera, lanza exception.
* ATOMIC_MOVE      - Asegura que la operación sobre el archivo sea atómica, para que los procesos vean registros completos. Depende de si está soportado o no por el FS.

## Using Path object
Podemos enlazar métodos sobre objetos de la clase Path, para transformala.
```java
//Chaining methods
Paths.get("/zoo/../home").getParent().normalize.toAbsolutePath();
```
### Viewing the Path with toString(), getNameCount() y getName()
```java
//toString()
Path path = Paths.get("/reports/e2e/jan/report1.txt");
System.out.println("The path name is: " + path);

//Path elements
for (int i = 0; i < path.getCount(); i++) {
    System.out.println("    Element " + i + " is: " + path.getName(i));
}
``` 
El elemento raíz no está incluído. Los elementos comienzan en 0 (cero).

### Accessing Path components
Podemos acceder a los elementos de un Path mediante numerosos métodos de un Path. Estos métodos regresan un objeto Path en sí mismos. 

El nombre del archivo. Para extraer el nombre del archivo (el cual es el elemento más lejano del Path) usamos el método getFileName():
```java
Path path = Paths.get("/home/augusto/Downloads/eee.txt");
Path filenamePath = path.getFileName();
```

Un objeto Path expone un método getParent() que representa el parent del archivo/directorio definido en el Path. Si el Path no tiene Parent, se regresa null. En una ruta relativa, el Path no atraviesa fuera del directorio actual llegando hasta el FS.
```java
Path path = Paths.get("/home/augusto/Downloads/eee.txt");
Path parentPath = path.getParent();
```

Finalmente, el método getRoot() devuelve el elemento del root, si existe o null si no existe porque el Path es relativo.
```java
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathComponentsExample {

    public static void main(String[] args) {

        printPathComponentsInfo(Paths.get("/", "reports", "feb", "report.txt"));
        System.out.println();
        printPathComponentsInfo(Paths.get("reports/feb/report.txt"));
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
```

### Checking Path type
Para verificar si un archivo es una ruta absoluta o relativa y para convertir una ruta relativa a un absoluta, la interface Path nos ofrece los métodos isAbsolute() y toAbsolutePath().
```java
Path path1 = Paths.get("C:\\checkiiing\\m0001\mx\file.cbl");
System.out.println("Path1 is absolute? " + path1.isAbsolute());
System.out.println("Absolute Path1: " + path1.toAbsolutePath());

Path path2 = Paths.get("mx\file.cbl");
System.out.println("Path2 is absolute? " + path2.isAbsolute());
System.out.println("Absolute Path2: " + path2.toAbsolutePath());
```

### New `Path`s with subpath()
```java
Path path = Paths.get("documents/important/monthly/report1.txt");
System.out.println("Paths is: " + path);

System.out.println("Subpath from 0 to 4 is: " + path.subpath(0, 4));
System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
```

### Path symbols
Para referirnos a elementos que se encuentran en el directorio actual, podemos utilizar el símbolo . (un punto) y para referirnos a elementos que se encuentran el el parent del directorio actual usamos .. (dos puntos). Combinado se pueden usar como ../../../report.txt para indicar que es un archivo tres directorios arriba del directorio actual.

### Driving a Path
relativize(Path)

### Joining Path objects
path.resolve(Path)

### Cleaning up a Path
normalize()

### Checking for file existence
path.toRealPath(); //sobre archivos 
path.toRealPath(); //sobre enlaces

//Para obtener acceso al directorio actual
Paths.get(".").toRealPath();

## Interacting with Files
Al igual que las clases Path y Paths nos ayudan a crear y manipular objetos `Path`s, NIO2 ofrece una clase helper llamada `java.nio.file.Files` o `Files`. A diferencia de Path y Paths, la mayoría de los métodos de Files lanzarán una checked exception si el archivo al que el Path se refiere no existe.

A pesar del nombre, `Files` no interactúa sobre objetos `File`, sino sobre objetos `Path`.

### Testing a Path
Files.exists(Path) verifica si el archivo referenciado por el Path existe en el FS:
```java
Files.exists(Paths.get("/tmp/salida.txt"));
Files.exists(Paths.get("./lesson10.md"));
Files.exists(Paths.get("src"));
```
Aplica para directorios y archivos.

### Testing uniqueness
isSameFile(Path, Path) si dos objetos Path apuntan al mismo archivo o directorio en el FS. Ojo, si en términos de equals() los dos objetos son iguales, isSameFile() regresa true sin validar que el archivo exista realmente en el filesystem. Si en términos de equals() los objetos son diferentes, el método ubica cada uno de los dos archivos en el FS y determina que se refieren al mismo archivo.

Es importante mencionar que no se compara el contenido del archivo, sino que se compara si los dos `Path`s se **refieren** al mismo archivo.

### Making directories
Files.createDirectory() y Files.createDirectories()

### Duplicating Files Contents
Files.copy()

### Changing a File ocation
Files.move()

### Removing a File
Files.delete(Path) y Files.deleteIfExists(Path)

### Reading and writing File Data
Files.newBufferedReader(Path, Charset)
Files.newBufferedWriter(Path, Charset)
Files.readAllLines(Path)

