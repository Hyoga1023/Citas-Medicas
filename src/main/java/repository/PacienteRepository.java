package com.sursalud.citasmedicas.repository;

import com.sursalud.citasmedicas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring genera automaticamente los metodos CRUD para Paciente
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}