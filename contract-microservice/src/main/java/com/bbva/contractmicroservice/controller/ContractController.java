package com.bbva.contractmicroservice.controller;

import com.bbva.contractmicroservice.entity.ContractEntity;
import com.bbva.contractmicroservice.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/contrato")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @GetMapping("/listar-contratos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarContratos() {
        List<?> contratos = contractService.findAll();
        if (!contratos.isEmpty()) {
            return ResponseEntity.ok(contratos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron contratos");
    }

    @GetMapping("/buscar-contrato/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarContrato(@PathVariable Long id) {
        ContractEntity contractEntity = contractService.findById(id);
        if (contractEntity != null) {
            return ResponseEntity.ok(contractEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el contrato");
    }

    @PostMapping("/registrar-contrato")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarContrato(@RequestBody ContractEntity contractEntity) {
        contractService.save(contractEntity);
    }

    @DeleteMapping("/eliminar-contrato/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarContrato(@PathVariable Long id) {
        contractService.deleteById(id);
    }
}

