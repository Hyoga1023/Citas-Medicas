package com.sursalud.citasmedicas.model;

import jakarta.persistence.*;
import lombok.Data;

// Este código Marca esta clase como una tabla en la base de datos
@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
}