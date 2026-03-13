# Proyecto de agenda de contactos
Este proyecto se utiliza como base para la introducción de conceptos de desarrollo de servicios Web REST en clase. 
En particular, este proyecto comenzó en la clase del día 9 de marzo de 2026.

# Construir el proyecto
Al ser un proyecto maven la forma más rápida de construirlo es ejecutar el siguiente comando en la consola, estando en el directorio donde se encuentra el fichero `pom.xml`.
```bash
mvn package
```
Maven puede instalarse siguiendo las instrucciones de la [página oficial de Maven](https://maven.apache.org/install.html).

# Ejecutar el proyecto

Una vez construido el proyecto podemos encontrar un fichero de extensión `jar` en el directorio `target`. 
Para ejecutar el servicio debemos escribir (asumiendo que estamos en el directorio donde se encuentra el fichero `pom.xml`:
```bash
java -jar target/daw-0.0.1-SNAPSHOT.jar
```
# Probar el servicio

El servicio arranca sin contactos en memoria. Para añadir un contacto podemos hacer un POST al endpoint `/contactos`. 
Se puede usar [Postman](https://www.postman.com) para ello. Alternativamente se puede utilizar el comando `curl` disponible
en muchos sistemas operativos. Un ejemplo con `curl` es el siguiente:
```bash
curl --location 'http://localhost:8080/contactos' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nombre": "Antonio",
    "apellidos": "García",
    "email": "antonio@uma.es",
    "telefono": "768678"
}'
```

Podemos consultar la lista completa de contactos con:
```bash
curl --location 'http://localhost:8080/contactos' \
--header 'Accept: application/json'
```

Podemos consultar un contacto en particular con:
```bash
curl --location 'http://localhost:8080/contactos/1'
```
