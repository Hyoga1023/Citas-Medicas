package com.sursalud.citasmedicas.controller;

import com.sursalud.citasmedicas.model.Medico;
import com.sursalud.citasmedicas.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medico> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Long id) {
        Medico medico = service.buscarPorId(id);
        if (medico == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public Medico crear(@RequestBody Medico medico) {
        return service.guardar(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Long id, @RequestBody Medico datos) {
        Medico existente = service.buscarPorId(id);
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