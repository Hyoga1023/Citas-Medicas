package com.sursalud.citasmedicas.repository;

import com.sursalud.citasmedicas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}