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

---

## Packages

Dentro del codigo del proyecto hay en total de 7 packages(Archivos) los cuales tenemos;

- [model](#model)
- [repository](#repository)
- [service](#service)
- [controller](#controller)
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

En el package solamente colocamos la anotacion **@Repository** y hacemos un **extends JpaRepository<Modelo, Integer>** que lo que hace es crear de forma automatica todos los metodos necesarios para mas adelante como **.findAll(), .save(), .findById(), ect** 

```java
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> { }
```

---

### Service

El package service colocamos la anotacion **@Service** donde se crean los metodos que se utilizaran en controller, en ella utilizaremos los mismo metodos creados en el package repository utilizando la anotacion **@Autowired** para utilizar los metodos

```java
    @Autowired
    private AutorRepository autorRepository;
```

Dentro del proyecto creamos principalmente 5 metodos que utilizaremos para cada service estos son;

#### **Obtener todos los datos**

```java
   public List<Autor> getAutor(){
       return autorRepository.findAll();
  }
```
#### **Guardar datos**

```java
   public Autor saveAutor(Autor autor){
       return autorRepository.save(autor);
    }
```
#### **Obtener dato por id**

```java
   public Autor getAutorId(Integer id){
       return autorRepository.findById(id).orElse(null);
    }
```
#### **Actualizar datos**

```java
   public Autor updateAutor(Autor autor){
       if(!autorRepository.existsById(autor.getId_autor())){
              return null;
       }
       return autorRepository.save(autor);
   }
```
#### **Borrar datos**

```java
   public void deleteAutor(Integer id){
       autorRepository.deleteById(id);
   }
```
---

### Controller

En el package controller creamos la conexion del Back-End y el Front-End para ello colocamos dentro la anotacion **@RestController** y **@RequestMapping("/api/v1/modelo")**

```java
@RestController
@RequestMapping("api/v1/autores")
public class AutorController {
```

Tambien hacemos la conexion con el package [service](#service) y utilizar los metodos creados en service

```java
    @Autowired
    private AutorService autorService;
```
En el controller construimos los metodos HTTP

#### Obtener todo
```java
    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores(){
        System.out.println("[AutorController] -> getAllAutores");
        return ResponseEntity.ok(autorService.getAutor());
    }
```
#### Obtener por id
```java
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getUsuarioId(@PathVariable Integer id){
        System.out.println("[AutorController] -> getUsuarioId id=" + id);
        Autor autor = autorService.getAutorId(id);
        if(autor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor);
    }
```
#### Guardar
```java
    @PostMapping
    public ResponseEntity<Autor> saveAutor(@Valid @RequestBody Autor autor){
        System.out.println("[AutorController] -> saveAutor");
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.saveAutor(autor));
    }
```
#### Actualizar
```java
    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Integer id, @Valid @RequestBody Autor autor){
        System.out.println("[AutorController] -> updateAutor id=" + id);
        autor.setId_autor(id);
        Autor actualizado = autorService.updateAutor(autor);
        if(actualizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
```
#### Borrar
```java
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAutor(@PathVariable Integer id){
        System.out.println("[AutorController] -> deleteAutor id=" + id);
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
```
---

El proyecto tiene un total de 6 End Points para acceder a sus metodos HTTP estas son:

#### End Points

 **Controller Autor:** `http://localhost:8080/api/v1/autores`

 **Controller Pelicula:** `http://localhost:8080/api/v1/peliculas`

 **Controller Productora:** `http://localhost:8080/api/v1/productoras`

 **Controller Usuario:** `http://localhost:8080/api/v1/usuarios`

 **Controller Watchlist:** `http://localhost:8080/api/v1/watchlist`

 **Controller Weather(API):** `http://localhost:8080/api/v1/clima`
 
---

### DTO

La funcionalidad de el package **DTO** es agarrar caracteristicas de otros modelos con la finalidad de tener varias caracteristicas de dos modelos en un solo **"modelo"**

```java
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PeliculaDTO {

    private String titulo_pelicula;
    private String genero_pelicula;
    private String nombre_productora;

}
```

Despues de crear el DTO creamos el metodo para llamar al DTO dentro del package service del que estemos haciendo un DTO

```java
    public List<PeliculaDTO> getPeliculaDTO(){
        return peliculaRepository.findAll().stream()
        .map(p -> new PeliculaDTO(
            p.getTitulo_pelicula(),
            p.getGenero_pelicula(),
            p.getProductora().getNombre_productora()
        ))
        .toList();
    }
```

Finalmente crearemos su metodo HTTP dentro del package controller para llamar al DTO

```java
    @GetMapping("/por-genero")
    public ResponseEntity<List<PeliculaDTO>> PeliculasPorGenero(){
        System.out.println("[PeliculaController] -> PeliculasPorGenero");
        return ResponseEntity.ok(peliculaService.getPeliculaDTO());
```
---

 ## **autores**
 - [Javier Fuentealba](https://github.com/Javier9897)
 - [Adriel Yañez](https://github.com/AdrielDuoc)
