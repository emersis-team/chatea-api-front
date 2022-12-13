# ChatEa

## Introduccion

**ChatEa** busca comunicar a las distintas partes del ejercito, reemplazando otros sistemas
de comunicacion que se usen dentro del ejercito. Para asi dejar de depender de estas
contando con un sistema propio.

Algunas funcionalidades deseadas para el chat fueron:  

- Un mapa para mostrar la ubicacion de los usuarios.
- Una sala de video conferencia.
- Un panel de administracion propio para manejar contactos, grupos y usuarios
	administradores.

Las tecnologias que usamos fueron:  

- PHP
- Java
- Javascript + VueJS

Estas las dividimos en tres capas en las que PHP se encarga de la persistencia de datos
y de brindar una api para su comunicacion con el exterior.  
Para la comunicacion con esta se usara un token JWT con informacion del
usuario. Asi la api podra verificar que esta siendo consultada por alguien
conocido.  
Con este token el server de VueJS va a realizar todas las peticiones al server.
El server de java es un middleware que la unica funcion extra que tiene es
validar contra `el Portal`/`el estado mayor` al momento de loguear un usuario.


## Instalacion

### Dependencias  

- Php 7.4.30
- Mysql 15.1
- Node 16.17.0
- Typescript 4.7.4
- Npm 8.15.0
- Java 17 
- Maven 3.6.3

[`Repositorio Middleware`](https://github.com/emersis-team/chatea-api-front)  
[`Repositorio Api`](https://github.com/emersis-team/api-chat)  
[`Repositorio Vuejs`](https://github.com/emersis-team/chat-ea-web-proyecto)  
[`Repositorio Mediasoup`](https://github.com/emersis-team/ws-video-room)  

Se necesitan 4 servers, uno para la `api`, otro para el `middleware`, otro para `vuejs`
y otro para `mediasoup`.  

Corriendo `npm install` en el server de vue js instalara las dependencias de vuejs.
Para windows puede tener problemas para una libreria: [`Mediasoup`](https://mediasoup.org/documentation/v3/mediasoup/installation/),
la cual tiene su guia de instalacion y de solucion de problemas.   

Para correr el server de video/`mediasoup` con nodejs. Para instalar las dependencias
se necesita correr *npm install --legacy-peer-deps* y *tsc && npm run start*
o *npx tsc && npm run start* para levantar la aplicacion.  
Tambien se necesitara abrir un los puertos **10000** al **10100** en el server para que la
aplicacion de video puede escuchar a los clientes en esos puertos.  

Para la aplicacion de php/`api` y de java/`middleware` configurar un server xampp con
php y con tomcat, para java se necesita subir el archivo war de la aplicacion, en la
carpeta webapps de xampp.  
Esto se logra compilando la aplicacion y empaquetandola en un war con: *mvn clean package*
Para levantar un server de desarrollo se puede hacer mismo desde maven con *mvn clean
spring-boot:run*.  

En la aplicacion de *vuejs* instalamos las dependencias con *npm install*,
compilamos y levantamos la aplicacion con *tsc && npm run start* o *npx tsc &&
npm run start*. Para levantarla en un servidor aparte se tiene que usar *tsc && npm run
build* o *npx tsc && npm run build* para crear los archivos estaticos en la
carpeta `/dist`, sirviendo esta carpeta y redirigiendo las peticiones al
`index.html` se puede usar en un server aparte.  

Para servir la aplicacion de *vuejs* desde el *middleware* se puede copiar el
contenido de la carpeta `/dist` de vue a `src/main/resources/static` del middleware,
y el archivo `/dist/index.html` reemplazarlo en `/src/main/resources/templates/`.  

## Video

La parte de video fue creada en NodeJs con una libreria especializada en el transporte
en tiempo real de datos, Mediasoup.  
La abstraccion que presenta Mediasoup se centra en **Producers** y **Consumers**.
Los **Producers** son los que se encargan de transmitir la informacion desde un cliente a un
**Router**(Un router representa una sala donde los producers y consumer comparten
conexiones)  
Los **Consumers** son instancias que se encargan de recibir la informacion 
Estos dos se crean con **TransportProducer** y **TransportConsumer** ambos son
instancias propias de la libreria que nos permiten instanciar tanto **Producers** y 
**Consumers** como connectarse y comunicarse con el server en casos de desconexion o
transmision de datos.  

Para asegurar el rendimiento en la transmision de datos, esto se hace por UDP en un
rango de puertos que se tiene que especificar en el codigo. Actualmente son los puertos
del **10000** al **10100**.  
Esto se hace para generar conexiones directas con los clientes y estos puedan transmitir
su informacion.  

La informacion que se envia puede ser de dos tipo, video y audio.  
Hay dos tipos de mimeType de video que se transmiten: "video/VP8", "video/H264".  
Esto es asi para poder diferencia cuando se transmite imagen de una pantalla que se esta
compartiendo o imagen de la camara de video de la persona.  

Tambien el server de video tiene un endpoint con el fin de atender conexiones que se
corten de improvisto y puedan cerrar toda la conexion con el server. Esto se hizo con un
evento propio del navegador que se dispara al cerrarse la pestaña.  

Para establecer la comunicacion con el server se usa web sockets, ya que es necesario
enviar informacion por parte del servidor a los clientes cuando estos no la pidan, este
es el caso cuando se cae un cliente de la llamada y los demas usuarios lo eliminan de la
pantalla o cuando se una una nueva persona y se deba agregar en los clientes actuales en
la video conferencia.  

En la aplicacion se crean dos/tres **Producers**, uno para transmitir audio, otro para
transmitir imagen de una camara y por ultimo una para transmitir pantalla. Esto es asi
para poder apagar cualquiera de estas fuentes de informacion de manera independiente.
De esta manera se emiten eventos por web socket para indicar cuando un producer esta
muteado o apago la camara.  

Una vez se crea un **Producer**, se envia un evento a todos los participantes del **room** y
cada uno pide todos los clientes que interactuan, luego el cliente valida cuales son los
nuevos y ahi crea un **Consumer** para ese nuevo participante de la llamada.  

Cada referencia de consumers y producers se ve reflejada en el servidor y en el cliente.
En ambos casos se guarda la referencia a las distintas instancias, para poder
eliminarlas o hacerle referencia cuando se necesite, por ejemplo, se guarda la
referencia de los **Producers** y **Consumers** con el nombre del grupo el cual esta
haciendo la video llamada, asi identificamos por cada room(nombre del grupo) que
participantes tiene.  

En la aplicacion algunos endpoints que se llaman por web socket son necesarios para la
aplicacion, ya que son eventos que se disparan desde dentro de la libreria. Por ejemplo
cuando se cierran las conexiones o cuando se piden parametros para emparejar que tipo de
informacion y formato tendra la transmision(RTPCapabilities).  

Para correr la aplicacion se necesita configurar correctamente los puertos, es decir,
que tengan salida a internet y configurar la ip publica del servidor en la variable de
entorno ADDRESS, tambien se necesita indicar el puerto del servidor en la variable de
entorno PORT.  

El server corre en https con certificados autofirmados, esto hace que en el navegador no
se autorize automaticamente los request a este destino y por ende se tiene que validar a
mano, una unica vez, de que se confia en el destino del host.  


## Middleware

El middleware es un intermedio entre la vista creada en vue y el backend creado en php.
Actualmente esta desarrollado con java 17 y maven 3.6.3.  
La unica funcionalidad extra que cumple este modulo es la verificacion de usuarios,
despues solo actuara como pasamanos con el backend.  

La validacion la hace contra el **Portal**, tambien podria dar que se valide contra otros
lugares, en ese caso en la aplicacion se penso que si un usuario es validado y
no existe en nuestro chat, el mismo usuario completara sus datos y se guardara como un
usuario nuevo en el chat.  

Otra de las funcionalidades del middleware es la de mantener las notificaciones de
nuevos mensajes a los usuarios mediante un web socket.  


## Mapa

## Administracion

