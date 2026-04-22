package com.Duoc.SceneIt.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;

    @NotBlank
    private String titulo_pelicula;

    @NotBlank
    private String autor;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String genero_pelicula;

    @NotBlank
    private String duracion;

    @NotBlank
    private String fechaEstreno_pelicula;

    

}
