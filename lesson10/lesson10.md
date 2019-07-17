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
