package com.bbva.accountmicroservice.service.impl;

import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;
import com.bbva.accountmicroservice.mapper.AccountMapper;
import com.bbva.accountmicroservice.repository.AccountRepository;
import com.bbva.accountmicroservice.service.AccountServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;
    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    @Order(1)
    void findByIdTest() {
        // Crear una cuentaDTO de prueba
        Long accountId1 = 123456789L;
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setIdCuenta(accountId1);
        accountDTO.setSaldo(new BigDecimal(1000));
        accountDTO.setFechaApertura(LocalDate.now());
        accountDTO.setCustomer(null);

        // Crear una cuenta de prueba
        Long accountId2 = 123456789L;
        Account account = new Account();
        account.setIdCuenta(accountId2);
        account.setSaldo(new BigDecimal(1000));
        account.setFechaApertura(LocalDate.now());
        account.setCustomer(null);

        // Simulando el comportamiento de un objeto real
        when(accountRepository.findById(accountId2)).thenReturn(Optional.of(account));
        when(accountMapper.toDto(account)).thenReturn(accountDTO);

        // Llamando al método que se va a probar
        AccountDTO result = accountService.getAccountById(accountId1);

        // Verificando que el método findById del repositorio fue llamado
        verify(accountRepository, times(1)).findById(accountId2);
        verify(accountMapper, times(1)).toDto(account);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(accountDTO, result);
    }

    @Test
    @Order(2)
    void saveAccount() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setIdCuenta(123456789L);
        accountDTO.setSaldo(new BigDecimal(1000));
        accountDTO.setFechaApertura(LocalDate.now());
        accountDTO.setCustomer(null);

        Account account = new Account();
        account.setIdCuenta(123456789L);
        account.setSaldo(new BigDecimal(1000));
        account.setFechaApertura(LocalDate.now());
        account.setCustomer(null);

        when(accountMapper.toEntity(accountDTO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.saveAccount(accountDTO);

        verify(accountMapper, times(1)).toEntity(accountDTO);
        verify(accountRepository, times(1)).save(account);

        assertEquals(account, result);
    }
    @Test
    @Order(3)
    void updateAccount() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setIdCuenta(123456789L);
        accountDTO.setSaldo(new BigDecimal(1000));
        accountDTO.setFechaApertura(LocalDate.now());
        accountDTO.setCustomer(null);

        Account account = new Account();
        account.setIdCuenta(123456789L);
        account.setSaldo(new BigDecimal(1000));
        account.setFechaApertura(LocalDate.now());
        account.setCustomer(null);

        when(accountRepository.findById(123456789L)).thenReturn(Optional.of(account));
        when(accountRepository.save(account)).thenReturn(account);

        accountService.updateAccount(123456789L, accountDTO);

        verify(accountRepository, times(1)).findById(123456789L);
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    @Order(4)
    void deleteAccount() {
        // Crear un accountId de prueba
        Long accountId = 123456789L;

        // Simulando el comportamiento de un objeto real
        doNothing().when(accountRepository).deleteById(accountId);

        // Llamando al método que se va a probar
        accountService.deleteAccount(accountId);

        // Verificando que el método deleteById del repositorio fue llamado
        verify(accountRepository, times(1)).deleteById(accountId);
    }
    @Test
    @Order(5)
    void getAccountsByCustomerId() {
        // Crear un customerId de prueba
        Long customerId = 1L;

        // Crear una lista de cuentas de prueba
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account();
        account1.setIdCuenta(123456789L);
        account1.setSaldo(new BigDecimal(1000));
        account1.setFechaApertura(LocalDate.now());
        account1.setCustomer(null);
        accounts.add(account1);

        // Crear una lista de AccountDTO de prueba
        List<AccountDTO> accountDTOs = new ArrayList<>();
        AccountDTO accountDTO1 = new AccountDTO();
        accountDTO1.setIdCuenta(123456789L);
        accountDTO1.setSaldo(new BigDecimal(1000));
        accountDTO1.setFechaApertura(LocalDate.now());
        accountDTO1.setCustomer(null);
        accountDTOs.add(accountDTO1);

        // Simulando el comportamiento de un objeto real
        when(accountRepository.findAccountsByCustomer_IdCliente(customerId)).thenReturn(accounts);
        when(accountMapper.toDtoList(accounts)).thenReturn(accountDTOs);

        // Llamando al método que se va a probar
        List<AccountDTO> result = accountService.getAccountsByCustomerId(customerId);

        // Verificando que el método findAccountsByCustomer_IdCliente del repositorio fue llamado
        verify(accountRepository, times(1)).findAccountsByCustomer_IdCliente(customerId);
        verify(accountMapper, times(1)).toDtoList(accounts);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(accountDTOs, result);
    }
}
