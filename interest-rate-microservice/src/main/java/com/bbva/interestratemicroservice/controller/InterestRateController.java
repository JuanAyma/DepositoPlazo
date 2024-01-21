package com.bbva.interestratemicroservice.controller;

import com.bbva.interestratemicroservice.entity.InterestRateEntity;
import com.bbva.interestratemicroservice.service.IInterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/tasaInteres")
public class InterestRateController {
    @Autowired
    private IInterestRateService interestRateService;

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarTasaInteres() {
        List<?> tasaInteres = interestRateService.findAll();
        if (!tasaInteres.isEmpty()) {
            return ResponseEntity.ok(tasaInteres);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron tasas de interes");
    }

    @GetMapping("/buscar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarTasaInteres(Long id) {
        Object tasaInteres = interestRateService.findById(id);
        if (tasaInteres != null) {
            return ResponseEntity.ok(tasaInteres);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la tasa de interes");
    }

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarTasaInteres(InterestRateEntity interestRateEntity) {
        interestRateService.save(interestRateEntity);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarTasaInteres(Long id) {
        interestRateService.deleteById(id);
    }
}
