package com.sursalud.citasmedicas.service;

import com.sursalud.citasmedicas.model.Paciente;
import com.sursalud.citasmedicas.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Contiene la logica de negocio para pacientes
@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}