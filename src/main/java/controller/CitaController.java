package com.sursalud.citasmedicas.controller;

import com.sursalud.citasmedicas.model.Cita;
import com.sursalud.citasmedicas.service.CitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cita> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable Long id) {
        Cita cita = service.buscarPorId(id);
        if (cita == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cita);
    }

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return service.guardar(cita);
    }

    // Cancela la cita cambiando su estado sin borrarla
    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Cita> cancelar(@PathVariable Long id) {
        Cita cita = service.cancelar(id);
        if (cita == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}