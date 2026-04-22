package com.Duoc.SceneIt.modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @NotBlank
    private String nombre_usuario;

    @NotBlank
    private String apellido_usuario;

    @NotBlank
    private String email_usuario;

    @NotBlank
    private String contraseña_usuario;

    @NotBlank
    private String fecha_creacion_cuenta_usuario;

    @NotNull
    private int edad_usuario;

    @NotNull
    private Productora productora;

}
