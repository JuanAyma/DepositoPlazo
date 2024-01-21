package com.bbva.accountmicroservice.controller;

import com.bbva.accountmicroservice.entity.AccountEntity;
import com.bbva.accountmicroservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/cuenta")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/listar-cuentas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarCuentas() {
        List<?> cuentas = accountService.findAll();
        if (!cuentas.isEmpty()) {
            return ResponseEntity.ok(cuentas);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cuentas");
    }

    @GetMapping("/buscar-cuenta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarCuenta(@PathVariable Long id) {
        AccountEntity accountEntity = accountService.findById(id);
        if (accountEntity != null) {
            return ResponseEntity.ok(accountEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la cuenta");
    }

    @PostMapping("/registrar-cuenta")
    @ResponseStatus(HttpStatus.CREATED)
    public void registrarCuenta(@RequestBody AccountEntity cuentaEntity) {
        accountService.save(cuentaEntity);
    }

    @DeleteMapping("/eliminar-cuenta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCuenta(@PathVariable Long id) {
        accountService.deleteById(id);
    }
}
