# SceneIt
SceneIt es un proyecto de una "Watchlist" que consiste en una app que permita a los usuarios guardar Peliculas que quieran ver en un futuro.

La finalidad de esta app es que los usuarios que ocupen la app puedan organizarce a la hora de querer ver peliculas que tengan pendiente.

---
>[!NOTE]
>Para ejecutar esta aplicacion se recomienda el uso de HeidiSQL y Laragon ademas de Postman
>
>[DESCARGA HEIDISQL](https://heidisql.com/download.php)
>
>[DESCARGA LARAGON](https://laragon.org/download)
>
>[DESCARGA POSTMAN](https://www.postman.com/downloads)
---
## Modelo del Proyecto

Para este Proyecto declaramos los modelos que consideramos mas importante para la Watchlist, estos son;

>[Usuario]
> - id_usuario
> - nombre_usuario
> - apellido_usuario
> - email_usuario
> - contraseña_usuario
> - fecha_creacion_cuenta_usuario
> - edad_usuario
>
> [Autor]
> - id_autor
> - nombre_autor
> - apellido_autor
> - edad_autor
>
> [Productora]
> - id_productora
> - nombre_productora
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
> [Watchlist]
> - id_watchlist
> - pelicula
> - usuario
> - tamano_watchlist

 ## **autores**
 - [Javier Fuentealba](https://github.com/Javier9897)
 - [Adriel Yañez](https://github.com/AdrielDuoc)
