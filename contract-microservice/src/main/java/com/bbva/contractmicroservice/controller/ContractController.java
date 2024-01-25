package com.bbva.contractmicroservice.controller;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.entity.Contract;
import com.bbva.contractmicroservice.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contrato")
public class ContractController {

    private final IContractService contractService;
    @Autowired
    public ContractController(IContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/listar-contratos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarContratos() {
        List<ContractDTO> contratos = contractService.findAll();
        if (!contratos.isEmpty()) {
            return ResponseEntity.ok(contratos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron contratos");
    }

    @GetMapping("/ver/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getContractById(@PathVariable Long accountId) {
        ContractDTO contract = contractService.findById(accountId);
        if (contract != null) {
            return ResponseEntity.ok(contract);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el contrato");
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Contract registrarContrato(@RequestBody ContractDTO contract) {
        return contractService.save(contract);
    }

    @DeleteMapping("/eliminar-contrato/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarContrato(@PathVariable Long id) {
        contractService.deleteById(id);
    }

    /////////////////////////////////////////////////////////////////////////////////

}

