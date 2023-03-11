# TallerPatrones
Este repositorio contiene el taller de Patrones de Software para el semestre 2022-1


## Problema a responder: 
Imagina que estás trabajando en una biblioteca de notificaciones que permite a otros programas notificar a sus usuarios acerca de eventos importantes.

La versión inicial de la biblioteca se basaba en la clase Notificador que solo contaba con unos cuantos campos, un constructor y un único método send. El método podía aceptar un argumento de mensaje de un cliente y enviar el mensaje a una lista de correos electrónicos que se pasaban a la clase notificadora a través de su constructor. Una aplicación de un tercero que actuaba como cliente debía crear y configurar el objeto notificador una vez y después utilizarlo cada vez que sucediera algo importante.

![https://refactoring.guru/images/patterns/diagrams/decorator/problem1-es.png?id=2dac64cd411324b4da466d52c11eb149](https://refactoring.guru/images/patterns/diagrams/decorator/problem1-es.png?id=2dac64cd411324b4da466d52c11eb149)

En cierto momento te das cuenta de que los usuarios de la biblioteca esperan algo más que unas simples notificaciones por correo. A muchos de ellos les gustaría recibir mensajes SMS sobre asuntos importantes. Otros querrían recibir las notificaciones por Facebook y, por supuesto, a los usuarios corporativos les encantaría recibir notificaciones por Slack.

Más adelante algún cliente pregunta: ¿por qué no se pueden usar varios tipos de notificación al mismo tiempo? A usted le piden que modifique nuevamente el diseño para considerar dicha situación, tratando de reutilizar lo que se pueda y dejando el diseño flexible para poder incorporar nuevas opciones.

## Justificación de la Solución Planteada

Ante el enunciado del ejercicio, se lograron sacar los siguientes requerimientos:
1.	Una aplicación Cliente (denominada Aplicación en el Diagrama 1) conoce una clase Notificador, es la encargada de crear y configurar este objeto y usarlo cuando algo importante ocurre.
2.	Se deben añadir las funcionalidadades para el envío de notificaciones por Facebook, SMS y mensajería empresarial.
3.	Se debe tener en cuenta que es posible que se deseen agregar más opciones de notificación más adelante.
Además de estas condiciones, al final se agrega la siguiente:
4.	Se debe tener en cuenta que se desean enviar varios tipos de notificaciones de manera concurrente.

En el código, se expone la sig. solución:

![](https://github.com/NicolleMayol/TallerPatrones/blob/main/Diagrama_UML.2drawio.drawio.png?raw=true)

En la cual Aplicación consume una interfaz que define los métodos comunes entre Notificador y Mensaje, que serán implementados posteriormente en estas clases. Se cumple el principio ISP puesto que ambas clases implementan los métodos.

Se creó una clase Mensaje, de la cual heredan los diferentes tipos de notificaciones a enviar. Esto permitirá que se puedan seguir agregando más tipos de notificaciones sin necesidad de modificar la clase padre, así siguiendo el principio OCP. Además, el hecho de tener cada clase de manera segmentada, permite respetar el principio de responsabilidad simple.

Se mantiene la funcionalidad inicial (Notificador se encarga de enviar notificaciones por email). 
En la parte superior se encuentra una clase denominada JSONManager, la cual tiene como funcionalidad gestionar la lectura y parseo del archivo JSON en el cual se encuentran los datos. Esta clase tiene una relación asoción con la interfaz. Si bien son las clases Mensaje y Notificador aquellas que hacen uso del objeto JSONManager, es más eficiente que la interfaz instancie ese objeto y que a través de las relaciones existentes entre este y las clases anteriormente mencionadas, pueda ser utilizado. Esto, en vez de agregar una relación independiente por cada clase. 

Entre la clase NotificadorInterfaz y Mensaje existe una relación de agregación, la cual indica que NotificadorInterfaz podrá o no tener Mensaje. Es decir, al enviar un mensaje, podrán ser notificados por Sms, Mensajería Empresarial, o no. Asimismo, debido a la relación de dependencia, se observa que sin esta interfaz no podría existir Mensaje.

Finalmente, se decidió relación de asociación entre el Cliente (Aplicación), y Creador. Esta clase Creador se encarga de instanciar los objetos para evitar que el cliente tenga instancias muy complicadas en caso de tener que aplicar diferentes tipos de notificaciones. 


### Identificación y justificación de patrones
1.	Patrón Decorator: Este ejercicio es un ejemplo clásico del uso del patrón decorador. La clase Mensaje es una capa que “decora” la clase Notificador, agregandole nuevas funcionalidades sin necesidad de modificarla. Esto permite estructurar la lógica empresarial en capas, crear un decorador para cada capa y componer objetos con varias combinaciones de esta lógica en tiempo de ejecución. El código del cliente puede tratar todos estos objetos de la misma manera, ya que todos siguen una interfaz común (NotificadorInterfaz). La clase Mensaje es el decorador base, mientras que la clase Notificador es un componente concreto. Además, las clases Facebook, MensajeriaEmpresarial y Sms corresponden a los decoradores concretos. 

2.	Patrón Builder: Asimismo, la clase Creador hace uso del patrón Builder. Este patrón permite producir diferentes tipos y representaciones de un objeto usando el mismo código de construcción.

<b> NOTA: Hay un error de notación en esta solución, puesto que NotificadorInterfaz tiene un parámetro (por lo que no es una interfaz). 
