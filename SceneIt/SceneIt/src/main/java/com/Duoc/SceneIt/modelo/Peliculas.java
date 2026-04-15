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
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String director;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String genero;

    @NotBlank
    private String duracion;

    @NotBlank
    private String fechaEstreno;

}
