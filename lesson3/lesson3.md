# Flow control statements
A menos que se indique lo contrario, la ejecución de las sentencias en un programa Java sucede de forma lineal; una sentencia tras otra, en secuencia. 
Pero existen algunas sentencias que nos permiten decidir si sí o no ejecutar una sentencia (o bloque de sentencias) en particular y otras que nos permiten ejecutar una sentencia (o grupo de sentencia) una y otra vez. Las decisiones están basadas en expresiones boolean (condiciones) que evalúan a true o false.
El orden de la ejecución de las sentencias se denomina *flow control* o *flujo de control*.

## if, if-else and switch statement
Cuando se requiere evaluar condiciones en un programa Java, se utiliza cuatro sentencias condicionales: `if`, `if-else`, `if-else-if` y `switch`. 

### if statement
La sintaxis de la sentencia `if` es la siguiente:
```java
if (condition) {
  // block of code to be executed if the condition is true
}
```
Ejemplo: Para el escenario en el que debemos mostrar un mensaje en pantalla que indique si un usuario tiene derecho a votar, de acuerdo a su edad (18 años) deberíamos usar una sentencia `if`
```java
if (user.age >= 18) {
  System.out.println("El usuario puede votar");
}
```

### if-else
Para el caso en el que sea necesario tomar acciones cuando se cumpla la condición y cuando no, utilizamos la sentencia `if-else`.
```java
if (condition) {
  // block of code to be executed if the condition is true
} else { 
  // block of code to be executed if the condition is false
} 
```
Ejercicio en pseudo-código: Indicar si un número es mayor, igual o menor a uno definido por el usuario:

Ejemplo: En una aplicación queremos recibir al usuario que ingresa con un saludo de acuerdo a la hora del día
```java
int time = 20;
if (time < 18) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// Outputs "Good evening."
```

### if-else-if
```java
if (condition1) {
  // block of code to be executed if condition1 is true
} else if (condition2) {
  // block of code to be executed if the condition1 is false and condition2 is true
} else {
  // block of code to be executed if the condition1 is false and condition2 is false
}
```
Ejemplo:
```java
int time = 22;
if (time < 10) {
  System.out.println("Good morning.");
} else if (time < 20) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// 
```

Ejercicio que reúne lo visto en clase:
Agregar un atributo `age` a la clase `Cat.java` que indique la edad en meses de un gato. Al igual que `name` y `color`, `age` se recibirá de la línea de comandos. En el método `main` se creará una instancia de tipo `Cat` y sus atributos tomarán los valores recibidos de la línea de comandos. Tras imprimir los tres atributos del objeto `Cat` creado, se imprimirá un mensaje en pantalla que indique si el gato es un cachorro, es jóven o adulto de acuerdo a:
- `age < 4` meses: Michu es un cachorro
- `age >= 4` meses pero `age < 12` meses: Michu es un jovenazo
- `age >= 12` meses: Michu es un gato adulto.

Finalmente, si solo se requiere ejecutar una sentencia (además corta) tanto para el `if` como para el `else` podemos utilizar el operador ternario:
`variable = (condition) ? expressionTrue : expressionFalse;`

Ejemplo:
```java
int time = 20;
String result = (time < 18) ? "Good day." : "Good evening.";
System.out.println(result);
```

## switch statement

## while statement

## do ... while statement

## for loop
