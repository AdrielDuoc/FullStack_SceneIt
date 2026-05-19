# SceneIt
SceneIt es un proyecto de una "Watchlist" que consiste en una app que permita a los usuarios guardar Peliculas que quieran ver en un futuro.

La finalidad de esta app es que los usuarios que ocupen la app puedan organizarce a la hora de querer ver peliculas que tengan pendiente.

## Indice
1.- [Estructura del Proyecto](#estructura-del-proyecto)

---
>[!NOTE]
>
>Para ejecutar esta aplicacion se recomienda el uso de las siguientes aplicaciones que nos permitiran correr el proyecto sin ningun problema.
>
>---
>[HeidiSQL]
>
>HeidiSQL es una base de datos, en el cual almacenaremos todos los datos atraves de un POST.
>
>[DESCARGA HEIDISQL](https://heidisql.com/download.php)
>
>---
>
>[Laragon]
>
>Laragon es una herramienta que sera utilizada para la conexion de la base de datos ocupando el sistema de MySQL.
>
>[DESCARGA LARAGON](https://laragon.org/download)
>
>---
>
>[Postman]
>
>Postman sera utilizada para utilizar los metodos https(GET, POST, PUT y DELETE) para interactuar con la base de datos.
>
>[DESCARGA POSTMAN](https://www.postman.com/downloads)
>
>---
---
# Estructura del Proyecto

Para comenzar con el proyecto se utilizaron las siguientes **dependencias** que nos permiten optimizar el codigo o tambien **realizar** la **conexion** con otras **herramientas**, **APIs**, ect.

## Dependencias

### Lombok

Lombok nos permite generar automaticamente todos los **metodos, Getters, Setters y constructores** de los [modelos](#model) del poyecto atraves de la anotacion **@Data, @AllArgsConstructor y @NoArgsConstructor**.

### DataJPA

DataJPA sirve para declarar nuestros [modelos](#model) como **entidades de una Base de Datos** para usarla se necesita usar la anotacion **@Data** y para declarar el modelo como entidad se usa la anotacion **@Entity** y luego la anotacion **@Table** que nos permite asignarle un nombre para el modelo en nuestra base de datos.

### Validation

Validation la utilizamos para declarar algunas caracteristicas de nuestros [modelos](#model) como tipo Id con la anotacion @Id.

Tambien la usamos para agregarles validaciones a las caracteristicas como por ejemplo hacer que sean **NotNull** o **NotBlank** con las anotaciones **@NotNull y @NotBlank**.

### WebMVC

WebMVC es una dependencia que se utiliza dentro del package de [controller]() con la anotacion **@RestController** esta nos permite hacer el **puente entre el Back-End y el Front-End**.

Esta libreria se utiliza para crear el EndPoint del controller con la anotacion **@RequestMapping** y tambien nos permite hacer los llamados **HTTP(GET, POST, PUT y DELATE)** con las anotaciones **@GetMapping, @PostMapping, @PutMapping y @DeleteMapping**.

Utilizaremos las anotaciones **@Valid** que su funcion es validar los argumentos que se ingresan dentro del metodo, **@RequestBody** que se utiliza para recibir un objeto **JSON** entero para convertirlo en un objeto y **@PathVariabe** que se utiliza para atrapar datos que vienen en una **URL** como el **Id** del modelo.

### WebFlux

WebFlux es una dependencia que nos permite hacer conexiones con **APIs** externas

### MySQL Connector

MySQL Connector es la libreria que nos permite conectarnos a nuestra Base de Datos MySQL

## Packages

Dentro del codigo del proyecto hay en total de 7 packages(Archivos) los cuales tenemos;

- [model](#model)
- [repository](#repository)
- [service]
- [controller]
- [dto]
- [exception]
- [config]


### Model
Para ir en orden comenzaremos con el **Package** de **model** en cual declaramos las entidades o modelos que consideramos mas importante.

Cada modelo tiene tambien sus caracteristicas como se ven a continuacion;

>---
>[Usuario]
> - id_usuario
> - nombre_usuario
> - apellido_usuario
> - email_usuario
> - contraseña_usuario
> - fecha_creacion_cuenta_usuario
> - edad_usuario
>
>---
>
> [Autor]
> - id_autor
> - nombre_autor
> - apellido_autor
> - edad_autor
>
>---
>
> [Productora]
> - id_productora
> - nombre_productora
>
>---
>
> [Pelicula]
> - id_pelicula
> - titulo_pelicula
> - autor
> - descripcion
> - genero_pelicula
> - duracion
> - fecha_estreno_pelicula
> - productora
>
>---
>
> [Watchlist]
> - id_watchlist
> - pelicula
> - usuario
> - tamano_watchlist
>---

### Repository





 ## **autores**
 - [Javier Fuentealba](https://github.com/Javier9897)
 - [Adriel Yañez](https://github.com/AdrielDuoc)
