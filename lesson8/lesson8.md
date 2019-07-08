# Collections, Enums, Numbers and Strings

## Collections 
Most common collections: ArrayList, HashSet and Map

## Enums

## Numbers
Normalmente utilizaremos números primitivos en nuestros programas Java. Sin embargo, existen escenarios en los que usaremos objetos en lugar de primitivos. Para esto, Java ofrece clases "wrapper" (envoltorio) para cada uno de los 8 tipos de primitivos de datos. 

### ¿Qué son los wrappers?
Estas clases "*envuelven*" a un primitivo dentro de un objeto. Cuando se necesita un objeto en lugar de un primitivo, y tú codificas un primitivo, el compilador "*boxes*" o lo pone en la caja por ti. De la misma manera, si usas un objeto donde se espera un primitivo, el compilador *lo saca de la caja* por ti. A estas dos operaciones se les llama [*autoboxing* y *unboxing*](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html), respectivamente.

Ejemplo de *autoboxing* y *unboxing*.

Cuando queremos utilizar colecciones, en lugar de arreglos, es necesario utilizar clases *wrapper*, porque las colecciones no admiten primitivos.

### Hierarchy
![Jerarquía de clases Number](https://docs.oracle.com/javase/tutorial/figures/java/objects-numberHierarchy.gif)
Algunos de los métodos implementados por todas las subclases de `Number` son:
```java
byte byteValue()
short shortValue()
int intValue()
long longValue()
float floatValue()
double doubleValue()
```

### Formatting

Java ofrece mecanismos que controlan muy bien las salidas de números a un OutputStream (por ejemplo, la consola), además de los métodos `print()` y `println()` que ya conocemos.

#### Los métodos `printf` y `format`

Los métodos `printf` y `format` residen en el objeto `PrintStream`, de `System`, el `System.out`. 

`System.out.format(.....)`

La sintaxis para estos métodos es:

`public PrintStream format(String format, Object... args)`

donde el parámetro `format` indica el formato a ser utilizado y `args` es la lista de variables a ser impresas usando este formato. Aquí un ejemplo:

```java
System.out.format("The value of " + "the float variable is " +
     "%f, while the value of the " + "integer variable is %d, " +
     "and the string is %s", floatVar, intVar, stringVar);
```
Los *Format specifiers* comienzan con un signo de porcentaje (%) y terminan con un convertidor. Es convertidor es un caracter que indica el tipo de argumento a ser formateado. Entre el signo de porcentaje y el convertidor, puedes tener banderas (flags) y especificadores opcionales. Existen muchos, muchos especificadores, convertidores y flags, que se encuentran documentados en [`java.util.Formatter`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html)

## Strings

Los `String`s o cadenas en Java, las cuales se utilizan muchísimo, son una secuencia de caracteres. En Java, los `String`s son objetos y así mismo nos ofrece la clase `String` para crearlas y manipularlas.

### How to create a String

La manera directa, y la más recomendada de crear una cadena es la siguiente:

`String greeting = "Hello world!";`

En este caso, la cadena *Hello world!* es una *literal String*, es decir, una serie de caracteres encerrada dentro de comillas dobles.
También puedes crear una cadena con la palabra reservada `new`, pero esto tiene varias implicaciones de performance que no están en el alcance de este curso. Solo digamos que no es correcto crearlas con `new`.

Puedes crear un String con uno de sus muchos constructores, incluído aquel que recibe un arreglo de caracteres como parámetro:
```java
char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
String helloString = new String(helloArray);
System.out.println(helloString);
```
Es importante mencionar que **la clase `String` es inmutable**. Sus métodos parecen modificar la cadena en sí misma, pero en realidad esto no sucede, sino que se crea una nueva cadena si estas operaciones son ejecutadas. Lo veremos más adelante.

### Length
Cómo conocer la longitud de una cadena:
`System.out.println("Esta es una cadena".length())`;

Ejemplo del Palindromo.

### Contatenando `String`s
La concatenación de cadenas se logra utilizando el operador `+` o con la operación `concat()`. Nuevamente, recordar que los `String`s son inmutables, lo que significa que la concatenación de cadenas genera una nueva cadena en lugar de modificar las originales.

`String concatenated1 = string1 + string2;`
`String concatenated2 = string1.concat(string2);`

## Converting between Numbers and Strings
En muchos programas Java sucede que las entradas o parámetros están dados en forma de cadenas y para su procesamiento lo requerimos en forma de números y viceversa.

Podemos convertir cadenas a números con las clases `Wrapper` que vimos en las secciones anteriores para lograr esta operación. Hagamos un ejercicio de TDD, con un método que convierta dos cadenas en números y nos devuelva la suma de estos:
```java
//La prueba...
@Test
public void convertAndAddNumbers() {
    Converter converter = new Converter();
    int sum = converter.convertAndAdd("5", "10");
    Assert.assertEquals(15, sum);
}

//La implementación...
public class Converter {
    public int convertAndAdd(String a, String b) {
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        
        return a1 + b1;
    }
}
```

Para convertir números a `String`s, la clase `String` provee el método `valueOf()`. También se puede pasar un número a string con el método `toString()` de las clases *wrapper*. Finalmente, podemos convertir un número en cadena concatenando una cadena vacía al número.
```java
int i = 25;
Integer w = 111;

String.valueOf(i);
w.toString();
String otherI = "" + i;
```

## Manipulando caracteres en un `String`

Existen varios métodos en la clase String que nos permiten manipular los caracteres que componen una cadena.
Para ejemplificarlo, usaremos las siguientes dos cadenas:
```java
String memberLine = "MEMBER NAME MDFT001";
String programLine1 = "02/07/2019|MDFT001|A|35|SQL|DB2|SELECT * FROM USERS";
String programLine2 = "02/07/2019|MDFT002|B|02|SQL|MYS|SELECT * FROM CLIENTS";
```

### Método `charAt()`

Imaginemos que estas cadenas tienen su origen en un archivo de operaciones de bases de datos recibido desde el exterior. El archivo tiene definido un layout para estas líneas, así que la posición de cada uno de los valores de la cadena ha sido establecida con anterioridad.
Si las letras `A` o `B` representan el tipo de operación y queremos extraerlas de las cadenas, usaremos el método `charAt(int index)` de cada cadena. El parámetro `index` representa la posición del caracter que queremos recuperar. Aquí hay que mencionar que los índices de una cadena comienzan por 0 (cero).

### Método substring()

Si por otro lado, queremos separa todos los elementos de las cadenas para su tratamiento, Java nos ofrece el método `susbtring(int beginIndex, int endIndex)`, con el cual podemos indicar que queremos extraer los caracteres desde el índice `a` hasta el índice `b` de la siguiente forma:

```java
String tx1 = programLine1.substring(11, 18); // MDFT001
String tx2 = programLine2.substring(11, 18); // MDFT002
```
El `endIndex` no es inclusivo, así que hay que indicar el `endIndex` con la posición que queremos más uno.

El método `substring` está sobrecargado, esto es, tiene otra *firma* que recibe solo un parámetro, el `beginIndex`. Este método nos devuelve todo los caracteres que haya desde el índice que le indiquemos hasta el último. Vamos a extraer el query de cada `programLine`:

```java
String query1 = programLine1.substring(32); // "SELECT * FROM USERS"
String query2 = programLine2.substring(32); // "SELECT * FROM CLIENTS"
```

### Método `split()`

Sirve para dividir una cadena, utilizando una secuencia de caracteres como separador y devolviendo un arreglo de cadenas como resultado:

```java
String programLine1 = "02/07/2019|MDFT001|A|35|SQL|DB2|SELECT * FROM USERS";
String[] parts = programLine1.split("|");

for (String s : parts) {
    System.out.println(s);
}
```

### Otros métodos

La clase String tiene muchísimos otros métodos convenientes para, por ejemplo, buscar palabras en una cadena, saber la posición en la que comienza una palabra contenida en la cadena (si es que la contiene), reemplazar una palabra por otra, etc.
Consulte la [documentación de `String`s](https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html) o en [comparando `String`s](https://docs.oracle.com/javase/tutorial/java/data/comparestrings.html) para conocer estos métodos.

## Comparando `String`s

Ya vimos en alguna lección anterior que la forma correcta de comparar si dos cadenas son iguales es a través del método `equals()` de la clase `String`. Esto nos asegura que son iguales en contenido aunque sean objetos diferentes en memoria.
```java
String s1 = "Hello";
String s2 = new String("Hello");

System.out.println(s1 == s2); // false
System.out.println(s1.equals(s2)); // true
```
## La clase `StringBuilder`
Recordemos que la clase `String` es inmutable, de tal forma que la concatenación de cadenas genera una nueva cadena cada vez. Esto no es un problema cuando la cantidad de cadenas a concatenar es pequeña. Pero imaginemos que requerimos concatenar cientos de miles o quizá millones de cadenas en una sola. Esto sería un grave problema de performace en nuestra aplicación, porque generaríamos una cantidad enorme de objetos tipo `String` y tendríamos algo como lo que sigue:
```java
String cadena = "";
cadena = cadena + "cadena1"; //"cadena1"
cadena = cadena + "cadena2"; //"cadena1cadena2"
cadena = cadena + "cadena3"; //"cadena1cadena2cadena3"
cadena = cadena + "cadena4"; //"cadena1cadena2cadena3cadena4"
cadena = cadena + "cadena5"; //"cadena1cadena2cadena3cadena4cadena5"
cadena = cadena + cadenaNumero10000000000000;
```

Cuando necesitamos "cadenas" que puedan mutar (en el caso de la concatenación) Java ofrece la clase `StringBuilder` y como su nombre lo indica, esta se encarga de contruir cadenas. Creamos un `StringBuilder` y le agregamos contenido de la siguiente manera:

```java
StringBuilder sb = new StringBuilder();
sb.append("Hola ");
sb.append("mundo!");
System.out.println(sb.toString());
```

## Conclusión

Cuando utilices un solo caracter, usa el primitivo `char`. Si necesitas solo un valor entero, utiliza el primitivo `int`. Pero existen ocasiones o necesidades que nos obligan a utilizar objetos en lugar de primitivos; es ahí donde entran en juego los *wrappers*. Dijimos que los *wrappers* envuelven a los primitivos de tal manera que permite que sean tratados como objetos donde se requieran, por ejemplo en la colecciones.

Las cadenas `String`s, muy útiles en Java, son secuencias de caracteres y a su vez son objetos. Las cadenas son inmutables. Podemos ejecutar muchas operaciones sobre objetos de tipo cadena, tales como concatenar, dividir, obtener una parte de esta, extraer un caracter de la misma en determinada posición, entre muchas otras. Utiliza el que más se ajuste a tu necesidad.

Si requieres concatenar muchas cadenas en tu programa, la recomendación es utilizar `StringBuilder`, que nos permite construir cadenas, agregando contenido y sin generar un nuevo objeto en cada concatenación.

## Para antes de la próxima clase...
1 Escribe un programa que concatene, de dos formas, las siguientes cadenas para obtener "Hola mundo!";
    ```java
    String hello = "Hola ";
    String world = "mundo!";
    ```
1 Escribe un programa al que le pases tu nombre completo, extraiga tus inicales y las imprima en la pantalla.
    ```java
    Para el nombre: Juan Perez Perez
    debe desplegar: JPP
    ```
1 Escriba un programa que imprima la tabla de multiplicar, del 1 al 10, de un número recibido como parámetro en forma de cadena.

