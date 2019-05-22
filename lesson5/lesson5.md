# Object Oriented Programming

En esta lección cubriremos la parte teórica del paradigma de Programación Orientada a Objetos, y seguidamente, con el conocimiento del lenguaje Java que has adquirido a lo largo de las lecciones anteriores, implementaremos OOP con Java.

## Conceptos clave de la OOP

## Objetos
* Los objetos son clave para entender la Programación Orientada a Objetos.
* Objetos del mundo real: un perro, escritorio, automóvil, televisión, bicicleta, etc.
* Los objetos del mundo real tienen estado y comportamiento (describa *state* y *behavior* de objetos a tu alrededor)
* Los objetos de software (*software objects*)

![Software Object](https://docs.oracle.com/javase/tutorial/figures/java/concepts-object.gif)
![Bike as Software Object](https://docs.oracle.com/javase/tutorial/figures/java/concepts-bicycleObject.gif)

* En los *software objects* el estado de los mismos se guarda en *campos* (fields) y exponen su comportamiento a través de *métodos* (methods). Son los *métodos* los que operan en el estado interno de los objetos y sirven como mecanismo de comunicación entre objetos.

## Encapsulamiento 
* Ocultar el estado interno de los objetos y obligar a que toda la comunicación entre ellos suceda a través de sus métodos, se conoce como *encapsulamiento* (encapsulation). 
* El encapsulamiento es también un concepto clave de la Programación Orientada a Objetos.
* Un objeto `bicicleta` expone un método `subirCambioVelocidad()`, y para hacerlo no expone el estado interno o el detalle de cómo lo hace (qué material de cadena, velocidad actual, posición de cambio actual, etc). 
* Para interactuar con el mundo exterior, el objeto `bicicleta` expone solo métodos y es el mismo objeto el que tiene el control de cómo objetos externos pueden interactuar con él.

## Beneficios de programar con objetos
* Modularidad. Construcción y mantenimiento independiente. Un objeto puede ser pasado alrededor de un sistema.
* Ocultamiento de información. Exponiendo solo métodos para interactuar con un objeto, permite ocultar su estado interno.
* Reutilización de código. Si ya existe, un objeto puede ser reutilizado, aunque tú no hayas sido el creador de dicho objeto (librerías).
* Fácil extensibilidad y depuración. Si un objeto no funciona, reemplázalo por otro. Una analogía puede ser una pieza mecánica.

## Clases
A nuestro alrededor o en el mundo real podemos distinguir que existen objetos que pueden considerarse del mismo tipo, podemos clasificarlos como algo general. En OOP, a esta clasificación general podría llamarse Clase.

## Clases e instancias de clase
Ahora, si como ejemplo pensamos en objetos tales como Automóvil, Bicicleta, Autobús, Barco, podríamos llamarlos a todos *Vehículos*. Si de estos elegimos el tipo de objeto Automóvil, y pensamos en un modelo en particular de coche (Ford Focus, por ejemplo) caemos en la cuenta que existen miles de estos autos. Misma marca, mismas características, mismo funcionamiento, mismos componentes, etc.

![Flotilla autos](https://hertzmexico.com/public/img/principales/venta-flota-autos.jpg) 

En términos de OOP, estos miles de autos de iguales características son *Instancias* de la *clase de objetos* `Automóvil`.
* Modelemos objetos de tipo Automóvil con una clase Java Car.java`, con los atributos `fabricante`, `velocidades`, `transmision`, `hp`, y los métodos `frenar`, `acelerar`, `mostrar tablero`.
* La idea es traducir el modelo Automóvil analizado a código Java. Aquí lo importante es el modelo (clase), no la sintaxis Java por sí misma, pero esta última refleja el diseño del modelo.

## Clases y aplicaciones
* El *entrypoint* de un programa Java es el método `main`.
* Una clase que tenga un método main es una aplicación en sí. 
* Automóvil no tiene un `main` porque no es un programa completo. Es solamente un *molde* que puede ser usado dentro de un aplicación.
* La responsabilidad de crear *instancias* de la *clase de objetos* Automóvil, es otra clase (cliente o caller) en la aplicación.
* Creamos la clase `CarApplication.java` y creamos en ella objetos tipo Car.

## Herencia
* Aunque no idénticos, muchos objetos tienen en común algo con otros. 
* Los autos utilitarios, los autos compactos y los autobuses, por ejemplo, comparten las características de un Automóvil, pero cada uno en particular tiene atributos y comportamiento específico y que pueden hacerlo distinto de los demás.
* La cantidad de asientos en un auto compacto es diferente de los de un autobús; el sistema de suspensión es distinto, el compartimento de maletas aparece en un autobus y no en un utilitario.
* En OOP, se permite que las clases *hereden* estado y comportamiento de otras clases. Por lo que surge el concepto de *superclase* y *subclase* (superclass, subclass, respectivamente).
* Automóvil se convierte en una superclase y utilitario, compacto y autobús en subclases de Automóvil.

![Car inheritance2](http://testingpool.com/wp-content/uploads/2015/08/Car-model.png)

* Implementemos subclases. Utilizar la palabra reservada `extends` para heredar entre clases.

## Intefaces
* Imagina qué sucede cuándo usas el control remoto para cambiar de canal el televisor o para subir y bajar volúmen. Los botones implicados en el control remoto son la *interface* entre ti y los componentes electrónicos del televisor.
* Los métodos de los objetos son su interface (API) con el mundo exterior.
* En Java, una interface es la definición de los métodos (el comportamiento) que objetos de cierto clase tendrá o expondrá.
* La interface no es el comportamiento como tal, es el contrato  de todo lo que un objeto debe hacer para poder ser llamado como se llama la interface.
* Implementemos una interface Vehículo, donde definamos (ojo, solo definir) qué comportamiento deben tener todas aquellas clases que quieran ser tratadas como un Vehículo.

## Paquetes
* Por último, pero no menos importante, revisaremos el tema de paquetes (`package`s) en Java. 
* Un paquete es un namespace pensado para organizar clases e interfaces relacionadas entre sí.
* Una analogía pueden ser los directorios de tu drive: personal, fotos, trabajo, etc.
* Una aplicación Java se puede componer de una sola clase o cientos o miles de estas. Así que los paquetes ayudan a mantener organizado el código.
* El API de Java está organizado en paquetes. Revisemos java.util, java.time, java.io, etc.
* Desarrollemos clases dentro de paquetes en nuestro proyecto. Aquí comienza a hacer sentido el uso de su IDE favorito.

## Tarea antes de la clase 6
* Repasar los temas de OOP en https://docs.oracle.com/javase/tutorial/java/concepts/index.html
* Más importante, investigar e implementar un ejemplo de Polimorfismo en Java. (Subir el código en un repo llamado clase6)
* Redactar en un archivo de texto "PropuestaProyecto.txt" la propuesta de proyecto final y subirla en el repo clase6. Esta tarea será tomada en cuenta en caso de que el curso entre como Ninja.
