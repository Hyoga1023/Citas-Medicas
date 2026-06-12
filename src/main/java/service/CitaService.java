package com.sursalud.citasmedicas.service;

import com.sursalud.citasmedicas.model.Cita;
import com.sursalud.citasmedicas.repository.CitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repository;

    public CitaService(CitaRepository repository) {
        this.repository = repository;
    }

    public List<Cita> listarTodas() {
        return repository.findAll();
    }

    public Cita guardar(Cita cita) {
        return repository.save(cita);
    }

    public Cita buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Cancelar significa cambiar el estado, no borrar el registro
    public Cita cancelar(Long id) {
        Cita cita = repository.findById(id).orElse(null);
        if (cita != null) {
            cita.setEstado("CANCELADA");
            return repository.save(cita);
        }
        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}