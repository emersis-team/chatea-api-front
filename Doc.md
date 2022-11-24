# ChatEa

Esta aplicacion busca poder comunicar a todo el ejercito enviando texto, video llamadas
y archivos.

Las tecnologias que usamos fueron:
- PHP
- Java
- Javascript + VueJS

Estas las dividimos en tres capas en las que PHP se encarga de la persistencia de datos
y de brindar una api para su comunicacion con el exterior.
Para la comunicacion con esta se usara un token JWT con informacion del
usuario. Asi la api podra verificar que esta siendo consultada por alguien
conocido.
Con este token el server de vueJS va a realizar todas las peticiones al server.
El server de java es un middleware que la unica funcion extra que tiene es
validar contra `el Portal`/`el estado mayor` al momento de loguear un usuario.

## Instalacion

### Dependencias
- php 7.4.30
- mysql 15.1
- node 16.17.0
- typescript 4.7.4
- npm 8.15.0
- java 8

Creamos la carpeta `cideso`.
(`repo Middleware`)[https://github.com/emersis-team/chatea-api-front]
(`repo Api`)[https://github.com/emersis-team/api-chat]
(`repo Vuejs`)[https://github.com/emersis-team/chat-ea-web-proyecto]
(`repo Mediasoup`)[https://github.com/emersis-team/ws-video-room]

Se necesitan 4 servers, uno para la `api`, otro para el `middleware`, otro para `vuejs`
y otro para `mediasoup`.

Corriendo `npm install` en el server de vue js instalara las dependencias de vuejs.
Para windows puede tener problemas para una libreria: (`Mediasoup`)[https://mediasoup.org/documentation/v3/mediasoup/installation/],
la cual tiene su guia de instalacion y de solucion de problemas. 

Para correr el server de video/`mediasoup` con nodejs. Para instalar las dependencias
se necesita correr `npm install --legacy-peer-deps` y `tsc && npm run start`
o `npx tsc && npm run start` para levantar la aplicacion.
Tambien se necesitara abrir un los puertos `10000` al `10100` en el server para que la
aplicacion de video puede escuchar a los clientes en esos puertos.

Para la aplicacion de php/`api` y de java/`middleware` configurar un server xampp con
php y con tomcat, para java se necesita subir el archivo war de la aplicacion, en la
carpeta webapps de xampp.

En la aplicacion de `vuejs` instalamos las dependencias con `npm install`,
compilamos y levantamos la aplicacion con `tsc && npm run start` o `npx tsc &&
npm run start`. Para levantarla en un servidor aparte se tiene que usar `tsc && npm run
build` o `npx tsc && npm run build` para crear los archivos estaticos en la
carpeta `/dist`, sirviendo esta carpeta y redirigiendo las peticiones al
`index.html` se puede usar en un server aparte.

Para servir la aplicacion de `vuejs` desde el `middleware` se puede copiar el
contenido de la carpeta `/dist` de vue a `src/main/resources/static` del middleware,
y el archivo `/dist/index.html` reemplazarlo en `/src/main/resources/templates/`.

