package com.sursalud.citasmedicas.repository;

import com.sursalud.citasmedicas.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}