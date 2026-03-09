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
