# Sentencias de control de flujo

## for loop
La sentencia `for`, mejor conocida como el ciclo `for` provee una forma compacta de iterar sobre un rango de valores. Las iteraciones pueden verse como *ciclos* que se ejecutarán mientras una condición en particular se cumpla. La sintaxis más común de un ciclo `for` es la siguiente:
```java
for (initialization; termination; increment) {
    //statement(s);
}
```
Si utilizas esta forma de declaración del ciclo for, recuerda que:
* La expresión de *inicialization*, inicializa el ciclo; esta expresión se ejecuta una vez, cuando comienza el ciclo.
* Cuando la expresión *termination* evalúa a `false`, el ciclo termina.
* La expresión de *increment* se invoca después de cada iteración en todo el ciclo; puede usarse para incrementar o decrementar un valor.

Ejemplo. Imprimir los números del 1 al 10. Para lograrlo, definimos la clase `OneToTen.java` con el siguiente código
```java
class OneToTen {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }
}
```
La salida es la siguiente: 
```bash
1
2
3
4
5
6
7
8
9
10
```
El scope de la variable de control (`i` en nuestro caso) es desde la declaración de la misma (`for (int i = 1; ...`) hasta el final del bloque de código del ciclo `for`, es decir, antes de la llave de cierre (`}`). Además, es posible declarar la variable de control fuera del scope del ciclo `for`, aunque si no es necesario, se recomienda declararla siempre dentro. Esto último acota bien el ciclo de vida de la variable y reduce errores potenciales.

Es posible, además, definir un ciclo for sin ninguna de las tres vistas anteriormente. Esto provocaría generar un ciclo infinito. La sintaxis es la siguiente:
```java
for ( ; ; ) {  
    // your code goes here
}
```
Existe una forma especial del ciclo `for` conocida como `for each` y está diseñada para iterar sobre colecciones y arreglos. También se le conoce como `enhanced for statement`. Las ventajas que ofrece son el diseño más compacto (menos código) y la mejora en la legibilidad del código:

Ejemplo. Supongamos que tenemos un arreglo de nombres y queremos imprimirlos en la pantalla:
```java
class PrintNameWithEnhancedFor {
    
    public static void main(String[] args) {
        
        String[] names = {"Marco", "Claudia", "Abraham", "Roberto"};
        
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```
La salida es la siguiente:
```bash
Marco
Claudia
Abraham
Roberto
```
Solo para puntualizar, el *`for` mejorado* no se interesa en el índice de cada elemento de la colección, sino en el elemento como tal.

Algo que es muy importante mencionar es que un ciclo `for` puede romperse si es necesario con la instrucción `break`. Veamos un ejemplo.

Ejemplo. Supongamos que tenemos una lista de números aleatorios entre 1 y 10. Queremos construir un programa que nos muestre en qué iteración se encontró determinado número, por decir algo, el 5 (si es que lo encuentra). Cuando encontremos el 5, romperemos el ciclo con `break`.
```java
class BreakFor {

    public static void main(String[] args) {
        
        int[] randomNumbers = generateRandomNumbers();

	    for (int i = 0; i < randomNumbers.length; i++) {   
	        if (randomNumbers[i] == 5) {
	    	    System.out.println("El 5 aparece en la posición: " + i);
		        break;
	        }
	    }
    }
    ...
}

```

## switch
La sentencia `switch` puede tener varias posibles rutas de ejecución. Un `switch`trabaja con los tipos de datos primitivos byte, short, char e int. Además, trabaja con tipos de datos enumerados, con la clase String y con algunas clases especiales wrapper de primitivos: Character, Byte, Short a Integer.

Ejemplo. Supongamos que queremos determinar el nombre del mes de acuerdo a un número de més recibido:
```java
...
public static void main(String[] args) {

    //Leemos en número de mes ingresado en la línea de comandos
    int month = Integer.parseInt(args[0]);
    String monthName;

    switch (month) {
        case 1: monthName = "January"; break;
	case 2: monthName = "February"; break;
	case 3: monthName = "March"; break;
	case 4: monthName = "April"; break;
	case 5: monthName = "May"; break;
	case 6: monthName = "June"; break;
	case 7: monthName = "July"; break;
	case 8: monthName = "August"; break;
	case 9: monthName = "September"; break;
	case 10: monthName = "October"; break;
	case 11: monthName = "November"; break;
	case 12: monthName = "December"; break;
	default: monthName = "Invalid month"; break;
    }
    
    System.out.println("The name of entered month is: " + monthName);
}
...
```
El cuerpo de una sentencia switch se conoce como switch block. Un switch block puede ser etiquetado con uno o más etiquetas case o default. La sentencia switch evalua su expresión, y ejecuta todas las sentencias que corresponden a la etiqueta que cumple la condición. ¿Cómo resolverías este ejemplo usando if-else-if? Complicado, no lo crees.

Como se puede observar, en este caso, cada switch block contiene una sentencia break, que se encarga de cerrar el bloque del case y que regresa el control del flujo a la primera sentencia después del switch. Si una sentencia break no acompaña a cada bloque, a partir de aquel case que se cumpla, todos los bloques de los demás `case`s se ejecutan en *fall through*. ¿Puedes comprobralo?. Aunque no es requerido, es recomendable utilizar un break en cada case.

## while

## do ... while

