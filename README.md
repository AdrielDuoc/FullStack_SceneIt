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
>HeidiSQL es una base de datos, en el cual almacenaremos todos los datos atraves de un POST
>
>[DESCARGA HEIDISQL](https://heidisql.com/download.php)
>
>---
>
>[Laragon]
>
>Laragon es una herramienta que sera utilizada para la conexion de la base de datos ocupando el sistema de MySQL
>
>[DESCARGA LARAGON](https://laragon.org/download)
>
>---
>
>[Postman]
>
>Postman sera utilizada para utilizar los metodos https(GET, POST, PUT y DELETE) para interactuar con la base de datos
>
>[DESCARGA POSTMAN](https://www.postman.com/downloads)
>
>---
---
## Estructura del Proyecto

Dentro del codigo del proyecto hay en total de 7 packages(Archivos) los cuales tenmos;

1.- [model](#model)
....* [package model]

- [repository]

- [service]
- [controller]
- [dto]
- [exception]
- [config]

Para ir en orden comenzaremos con el primer package que se necesita para comenzar con el proyecto, el cual seria el package **model** 







## Model

Para este Proyecto declaramos los modelos que consideramos mas importante para la Watchlist, estos son;

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



 ## **autores**
 - [Javier Fuentealba](https://github.com/Javier9897)
 - [Adriel Yañez](https://github.com/AdrielDuoc)
