package com.sursalud.citasmedicas.controller;

import com.sursalud.citasmedicas.model.Paciente;
import com.sursalud.citasmedicas.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Expone los endpoints REST para el recurso Paciente
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = service.buscarPorId(id);
        if (paciente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente datos) {
        Paciente existente = service.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        datos.setId(id);
        return ResponseEntity.ok(service.guardar(datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}