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

Corriendo `npm install` en el server de vue js instalara las dependencias de vuejs.
Para windows puede tener problemas para una libreria: (`Mediasoup`)[https://mediasoup.org/documentation/v3/mediasoup/installation/],
la cual tiene su guia de instalacion y de problemas. 

Para correr el server de video se necesitara otra aplicacion en nodejs. Para
instalarla se necesita correr `npm install --legacy-peer-deps` y `tsc && npm run start`
o `npx tsc && npm run start`. Tambien se necesitara abrir un los puertos `10000` al `10100`
en el server para que la aplicacion de video puede escuchar a los clientes en
esos puertos.

Para la aplicacion de php y de java se necesita configurar un server xampp con
php y con tomcat para java subiendo el archivo war de la aplicacion.

