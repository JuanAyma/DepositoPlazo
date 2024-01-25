package com.bbva.accountmicroservice.controller;

import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;
import com.bbva.accountmicroservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountController {
    private final IAccountService accountService;
    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/listar-cuentas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listarCuentas() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        if (!accounts.isEmpty()) {
            return ResponseEntity.ok(accounts);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cuentas");
    }
    @GetMapping("/ver/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        AccountDTO accountDTO = accountService.getAccountById(accountId);
        if (accountDTO != null) {
            return ResponseEntity.ok(accountDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la cuenta");
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Account registrarCuenta(@RequestBody AccountDTO account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/customer/{customerId}/accounts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> byCustomerId(@PathVariable Long customerId) {
        List<AccountDTO> accounts = accountService.getAccountsByCustomerId(customerId);
        if (!accounts.isEmpty())
            return ResponseEntity.ok(accounts);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron cuentas");
    }


}
/*
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
        Object accountEntity = accountService.findById(id);

        if (accountEntity != null) {
            return ResponseEntity.ok(accountEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la cuenta");
    }



    @DeleteMapping("/eliminar-cuenta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarCuenta(@PathVariable Long id) {
        accountService.deleteById(id);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        Account createdAccount = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }


*/