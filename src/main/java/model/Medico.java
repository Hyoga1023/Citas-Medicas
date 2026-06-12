package com.sursalud.citasmedicas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String consultorio;
}