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
        for(int i = 1; i < 11; i++) {
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
## switch

## while

## do ... while

