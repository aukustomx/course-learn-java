## Lesson 2 Introducción a la Sintaxis Java

* Estructura de un archivo Java
* Un programa de arriba a abajo
* El ciclo de vida de un Programa Java
* Definiendo y ejecutando Programas Java
* Crear archivo de una clase Cat.java
* Implementar código de clase Cat.java
* Compilar con javac
* Ejecutar con java
* Tipos de datos primitivos
* Expresiones y operadores
* Campos/variables
* Métodos
* Arreglos

## Estructura de un archivo Java
En OOP la idea es abstraer los problemas utilizando objetos del mundo real.
Imaginemos que en una aplicación de una clínica veterinaria consideraremos modelar mascotas, y para efectos de ejemplo, modelaremos un gato.
Así que comenzamos por definir al gato:
* Nombre del objeto: Cat
* Atributos del objeto:
  * Name: Michu
  * Color: Gray
* Comportamientos:
  * walk()
  * talk()  
  * eat()
  * play()

Propóngan un ejemplo de un objeto del mundo real que tenga atributos y comportamiento.

Si trasladamos estos atributos y comportamientos de un gato a una clase Java, tendríamos lo siguiente:
![Java file structure](http://java5tutor.info/images/classsyntax.jpg "Java file structure")

## Un programa de arriba a abajo
Analicemos las partes de una clase.

Es importante mencionar que existen muchas, muchas, muchas maneras de definir una clase. Así que sería equivocado pensar que todas las clases lucirán como esta. El alcance de este curso no es entrar en el detalle de la especificación del lenguaje, sino ofrecer un panorama de alto nivel del mismo y un approach de **"Java usable"**

## El ciclo de vida de un Programa Java
![Java program lifecycle](https://www.w3resource.com/java-tutorial/images/Java-Program-Life-Cycle.png "Java program lifecycle")

## Definiendo y ejecutando Programas Java
* Crear un archivo nuevo (con el editor que prefieran)
* Guardarlo con el nombre de la clase, en UpperCamelCase, más la extensión `.java`

## Implementar código de clase Cat.java

Definir en la clase un método de la forma `public static void main(String[] args) { ... }`. Este método, escrito tal cual se muestra aquí, es el *entrypoint* a los programas Java.

## Compilar con javac

Compilar el programa con la utilería `javac ` como sigue:
  ```bash
  javac Cat.java
  ```
Este comando genera bytecode dentro de un archivo `.class`. En el tema de clases anidadas (inner classes) veremos que de un archivo pueden producirse más de un archivo `.class`.

## Ejecutar con java

Ejecutar el programa `Cat` con Java
```bash
  java Cat
  ```
* **Nota:**  Desde la versión 11 de Java tenemos la posibilidad de compilar y ejecutar programas de un solo archivo `.java`(repito, programas de un solo archivo `.java`) con un solo comando: 
```bash
  java Cat.java
  ```
## Tipos de datos primitivos
En Java exiten 8 [tipos de datos primitivos](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html):
1. boolean
1. byte
1. short
1. char
1. int
1. long
1. float
1. double

Type| Contains |	Default	  |Size |	Range
---|---|---|---|---
boolean|	true or false|	false|	1 bit|	NA
char|	Unicode character|	\u0000|	16 bits|	\u0000 to \uFFFF
byte|	Signed integer|	0|	8 bits|	-128 to 127
short|	Signed integer|	0|	16 bits|	-32768 to 32767
int|	Signed integer|	0|	32 bits|	-2147483648 to 2147483647
long|	Signed integer|	0|	64 bits|-9223372036854775808 to 9223372036854775807
float| IEEE 754 floating point |0.0	|32 bits| ±1.4E-45 to ±3.4028235E+38
double | IEEE 754 floating point|  0.0|	64 bits| ±4.9E-324 to ±1.7976931348623157E+308


## Expresiones y operadores
Una **expresión** es una combinación de variables, operadores y llamadas de métodos construida de acuerdo a la sintaxis del lenguaje que devuelve un valor. Para indicar el fin de una sentencia, se utiliza un `;`. Ejemplos:
```java
/**
 * Comentario de bloque
**/
String name = "Michu"; //Una asignación a una variable String
int age = 5; //Una asignación a una variable String
Path pathToFile = Paths.get("/tmp"); //La definición de una ruta 
validate(int value); //La llamada a métodos
//Comentario de línea
```
De paso, se puede observar que en Java existen comentarios de línea y de bloque.

Los **operadores** son símbolos especiales que por lo común se utilizan en expresiones.  Los operadores realizan operaciones sobre uno, dos o tres operandos y regresan un valor o resultado. Java ofrece operadores en las siguientes categorías: 
* Arithmetic Operators
* Bitwise Operators
* Relational Operator
* Logical Operator

Veamos operadores que se utilizan en Java:

| Operators	      | Precedence                              |
|----------------|------------------------------------------|
|postfix	        | expr++ expr--                            |
|unary	          | ++expr --expr +expr -expr ~ !            |
|multiplicative	 | \* / %                                   |
|additive	       | + -                                      |
|shift	          | << >> >>>                                |
|relational	     | < > <= >= instanceof                     |
|equality	       | == !=                                    |
|bitwise         | AND	&                                    |
|bitwise         | exclusive OR	^                           |
|bitwise         | inclusive OR	|                           |
|logical         | AND	&&                                   |
|logical         | OR	||                                    |
|ternary	        | ? :                                      |
|assignment	     | = += -= \*= /= %= &= ^= |= <<= >>= >>>=  |

Ejemplos:
```java
5 + 2;
!isValid;
25 * 2 - 10;

```
En el curso no veremos todos y cada uno de los operadores, pero se mencionan aquí para que los tengan presente y en caso de necesitarlos, sepan que existe y los tiene disponibles.

## Campos/variables
Ya hablamos anteriormente acerca de los atributos/propiedades que tiene una clase en Java. Comunmente, en Java se suele utilizar tanto *campo* (*field*) como *variable* como equivalentes, pero hay distinciones entre estos:

* **Instance Variables** (Non static field)
* **Class Variables** (Static Fields)
* **Local Variables**
* **Parameters**
Vamos a revisar estos conceptos con una clase `Counter.java` de ejemplo.

# Arreglos
Un array es un contenedor de objetos que almacena un numero definido de estos y de un solo tipo. La longitud de un arreglo se define al momento en que el array es creado. Una vez creado, su longitud no cambia. 
![Java Array](https://docs.oracle.com/javase/tutorial/figures/java/objects-tenElementArray.gif "Java Array")
Cada item en un arreglo es llamado *elemento* y un elemento de un arreglo es accedido a través de su índice numérico, comenzando con 0 (cero)
Ejercicio:
* Declarar una variable que apunte a un arreglo
* Crear e inicializar el arreglo
* Acceder elementos en el arreglo

# Reading command line arguments
Es un argumento de linea de comandos aquel que es pasado a un programa Java cuando se ejecuta. Recordemos el programa Cat. Supongamos que queremos establecer el nombre y el color un objeto Cat con los parámetros recibidos en la línea de comandos como sigue:
`java Cat Michu Negro`

Si seguimos recordando el programa Cat, definimos un método `main` que funciona como el punto de entrada a nuestro programa; Java busca este métod y comienza a ejecutar las sentencias que están dentro del cuerpo de este método. `main` recibe un arreglo de `String`s como parámetro. Si ningún parámetro es pasado al programa por la línea de comandos, la longitud del arreglo de parámetros es 0.

Antes de hacer que el programa Cat reciba 2 parámetros, los use para definir el nombre y el color del gato e imprima sus valores en la pantalla, vamos a resolver algunos ejercicios:
* Escribir un programa que reciba un nombre propio e imprima en la pantalla "Hola, aquí-va-el-nombre-como-parámetro!", por ejemplo:
`PrintName Juan` debe imprimir
`Hola, Juan!`

* Escribir un programa que reciba 2 números enteros, los sume, e imprima: "El resultado de sumar x1 más x2 es igual a aquí-va-el-resultado-de-la-suma"
Recuerden, los arreglos comienzan en 0 y se acceden de la forma nombreArreglo[0], nombreArreglo[1] y así sucesivamente.

* Ahora sím es momento de implementar el programa Cat para que lea dos parámetros de la línea de comandos, asigne dichos parámetros al nombre y el color del gato y finalmente imprima los atributos del gato en la pantalla.

## Tarea
Leer las siguientes secciones de la documentación de Oracle acerca de Operadores, y Expresiones, sentencias y bloques. Tema principal y subtemas. La siguiente clase habrá preguntas de las lecturas.

* [Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
  * Assignment, Arithmetic, and Unary Operators
  * Equality, Relational, and Conditional Operators
   * Bitwise and Bit Shift Operators
  * Summary of Operators
  * Questions and Exercises
* [Expressions, Statements, and Blocks](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/expressions.html)
  * Questions and Exercises
* Implementar al menos un ejemplo de arreglos multidimensionales.* Tarea: arreglos multidimens
