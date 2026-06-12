package com.sursalud.citasmedicas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;

    // Estado puede ser: PENDIENTE, CONFIRMADA, CANCELADA
    private String estado;

    // Relacion con Paciente: una cita pertenece a un paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    // Relacion con Medico: una cita pertenece a un medico
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}