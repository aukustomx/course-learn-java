# Polimorfismo

La definición de *polimorfismo* *(del griego: πολύ «poli» = muchos, y μορφή «morfé» = **forma**, figura)* se refiere a un principio de la biología en el cual un organismo o especie puede tener diferentes formas o estapas. 

Otra definición sería que el *polimorfismo* sucede cuando en una población de la **misma especie** hay dos o más fenotipos claramente diferenciados, es decir, existe **más de una forma** de dicha especie. 

El principio de *polimorfismo* puede ser aplicado a la Programación Orientada a Objetos (OOP) y a lenguajes como Java. En este caso, las subclases de una clase pueden definir su propio comportamiento, y al mismo tiempo compartir alguna funcionalidad de la clase padre.

Para demostrar las características polimórficas del lenguage Java, veamos un ejemplo con clases que se refieren a empleados.

![Employees Hierarchical Structure](http://www.plantuml.com/plantuml/png/Iyv9B2vMSCqjoCclJ4rLgERYKW22fFoyqc8hXSoy4WW_FRN42IIaeQa04Qtbuae6wmpEJqaiHj8EKar0YrDYNZPfEjppouZL05TdKwEhY-OwAuNKYfBKl9HYD5Ke3iAb2DaDS3K0)

## Clases y subclases
En el diagrama anterior se pueden observar varios temas que ya hemos revisado en anteriores lecciones:

* Clase ()
* Atributos de clase (estado)
* Métodos (comportamiento)
* Herencia
* Subclases
* Superclase

Podemos decir que existe una clase padre, en este caso Employee, y que a su vez, 3 subclases extienden esta superclase: SodasEmployee, BankEmployee, GovEmployee. 

De forma análoga al ejemplo de las especies en Biología, podríamos decir que hay una *especie* llamada Employee y 3 formas de dicha especie: SodasEmployee, BankEmployee, GovEmployee; por lo tanto Employee tiene muchas formas o es polimórfico.

## Referencia tipo clase, objetos tipo subclase
En lenguaje Java el código que trata las diferentes formas de Employee sería el siguiente:

```java
...
    //Traditional object and reference creation
    Employee employee = new Employee(5);
    GovEmployee govEmployee = new GovEmployee(10_000);
    SodasEmployee sodasEmployee = new SodasEmployee(15_000);
    BankEmployee bankEmployee = new BankEmployee(20_000);
        
    //Polimprphic way object and reference creation
    Employee empl2 = new Employee(5);
    Employee gov2 = new GovEmployee(10_000);
    Employee sodas2 = new SodasEmployee(15_000);
    Employee bank2 = new BankEmployee(20_000);
...
```
Con el polimorfismo, podemos referirnos a objetos del mismo tipo (*especie*) aunque cada uno tenga tipos específicos.

Esto ofrece muchas ventajas. Una es poder procesar diferentes objetos que comparten un tipo en un método *genérico*. 

Ejemplo: Imaginen que queremos procesar el pago del bono de cada empleado. Sin utilizar ni herencia ni polimorfismo, tendríamos que implementar un método por cada tipo como sigue:
```java
   processGovEmployeeBonus(GobEmployee govEmployee) {
       int bonus = govEmployee.getBonus();
       //process bonus
   }
   
   processSodasEmployeeBonus(SodasEmployee sodasEmployee) {
       int bonus = sodasEmployee.getBonus();
       //process bonus
   }
   
   processBankEmployeeBonus(bankEmployee bankEmployee) {
       int bonus = bankEmployee.getBonus();
       //process bonus
   }
```

Si el procesamiento del bono es el mismo para cada empleado, no importando su subtipo, de esta forma estamos implementando código innecesario; peor aun, si surgiera la necesidad de crear otro subtipo de empleado, dígase AutomitiveEmployee o PostServiceEmployee, tendríamos que implementar métodos adicionales. Esto es un problema en reutilización y mantenimiento de código.

La solución que el polimorfismo ofrece para este problema es la siguiente:
```java
    processEmployeeBonus(Employee employee) {
        int bonus = bankEmployee.getBonus();
       //process bonus
    }
```

En lugar de tener un método para cada subtipo, implementamos un único método con el supertipo y esto nos permite reutilización de código, facilidad de mantenimiento y extensibilidad, es decir, que si se generan nuevos subtipos de la clase Employee, este método está preparado para soportarlos.

Un punto importante a observar en este ejemplo, es que la Java virtual machine (JVM) llama al método apropiado en el objeto correspondiente al que se refiere cada variable. Por lo tanto, la JVM no llama el método definido de acuerdo al tipo de variable. Este comportamiento se llama *virtual method invocation* y demuestra un aspecto de la importancia del polimorfismo en el lenguaje Java.

# Arquetipos maven

Siendo breves, un Arquetipo (Archetype) es una herramienta de plantilla de proyecto. Un arquetipo está definido como un *patrón original* o *modelo del cual se hacen otras cosas del mismo tipo*. Es una forma de generar de forma consistente proyectos Maven.

Los arquetipos permiten a los desarrolladores inicien un proyecto de forma rápida, de forma consistente, y con las mejores prácticas implementadas por la organización autora del arquetipo.

Para crear un proyeto Meven con el arquetipo (plantilla) llamada `maven-archetype-quickstart` ejecutamos el siguiente comando:

```bash
$ mvn archetype:generate \
> -DarchetypeGroupId=org.apache.maven.archetypes \
> -DarchetypeArtifactId=maven-archetype-quickstart \
> -DarchetypeVersion=1.4 \
> -DgroupId=com.mycompany \
> -DartifactId=my-project \
> -Dversion=1.0 \
> -DinteractiveMode=false
```
La línea `mvn archetype:generate` le indica a maven que lo que quieres es generar un proyecto a partir de un arquetipo.

`-DarchetypeGroupId=org.apache.maven.archetypes` define el groupId del arquetipo deseado. Esto es algo así como la marca de los artefactos que se generan. En este caso, se puede ver que este arquetipo le pertenece a la empresa apache.

La siguiente línea es `-DarchetypeArtifactId=maven-archetype-quickstart` y es el nombre del artefacto. Seguramente apache genera cientos de miles de artefactos de software y a cada uno le pone un nombre. Nosotros como desarrolladores pondremos nombre al software que desarollemos. 

En cuanto al arquetipo se refiere, tenemos finalmente que establecer qué versión del mismo queremos, en este caso indicamos que usaremos la versión 1.4 del arquetipo como `-DarchetypeVersion=1.4`.

Las líneas restantes del comando se refieren a nuestro componente de software *per se*. En el ejemplo, se genera un proyecto que pertence a la compañía `mycompany` (`-DgroupId=com.mycompany`), el nombre de nuestro artefacto o componente de software será `my-project` (`-DartifactId=my-project`) y la versión será la 1.0 (`-Dversion=1.0`).

`-DinteractiveMode=false` es un modo en el que Maven va preguntándonos y nosotros constestando los datos que acabamos de revisar. Pero como ya definimos esta información en el mismo comando, le instruímos a Maven que cree el proyecto en modo batch, en decir, sin preguntarnos.

El comando anterior genera un proyecto Java con la siguiente estructura:
```bash
my-project/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── bbva
    │               └── App.java
    └── test
        └── java
            └── com
                └── bbva
                    └── AppTest.java

9 directories, 3 files

```