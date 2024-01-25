/*
package com.bbva.accountmicroservice.service.impl;

import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;
import com.bbva.accountmicroservice.repository.AccountRepository;
import com.bbva.accountmicroservice.service.AccountServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CurrencyRepository currencyRepository;
    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    @Order(1)
    void createAccount() {
        // Crear un AccountDTO con datos de prueba
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setSaldo(BigDecimal.valueOf(1000));
        accountDTO.setFechaApertura(LocalDate.now());
        accountDTO.setEstadoCuenta("Activo");
        accountDTO.setIdCliente(1L);
        accountDTO.setIdMoneda(1L);

        // Crear objetos de prueba para Customer y Currency
        Customer customer = new Customer();
        Currency currency = new Currency();

        // Crear una cuenta de prueba
        Account account = new Account();
        account.setSaldo(accountDTO.getSaldo());
        account.setFechaApertura(accountDTO.getFechaApertura());
        account.setEstadoCuenta(accountDTO.getEstadoCuenta());
        account.setCustomer(customer);
        account.setCurrency(currency);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findById(accountDTO.getIdCliente())).thenReturn(Optional.of(customer));
        when(currencyRepository.findById(accountDTO.getIdMoneda())).thenReturn(Optional.of(currency));
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        // Llamando al método que se va a probar
        Account result = accountService.createAccount(accountDTO);

        // Verificando que los métodos findById y save fueron llamados
        verify(customerRepository, times(1)).findById(accountDTO.getIdCliente());
        verify(currencyRepository, times(1)).findById(accountDTO.getIdMoneda());
        verify(accountRepository, times(1)).save(any(Account.class));

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(account, result);
    }
}*/


/*@Test
@Order(2)
void getAccountByIdTest() {
        Long accountId = 1L;
        Account account = new Account();
        account.setId(accountId);

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountMapper.toDto(account)).thenReturn(new AccountDTO());

        AccountDTO result = accountService.getAccountById(accountId);

        verify(accountRepository, times(1)).findById(accountId);
        verify(accountMapper, times(1)).toDto(account);

        assertNotNull(result);
        }

@Test
@Order(3)
void getAllAccountsTest() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(1L);
        accounts.add(account);

        when(accountRepository.findAll()).thenReturn(accounts);
        when(accountMapper.toDtoList(accounts)).thenReturn(new ArrayList<>());

        List<AccountDTO> result = accountService.getAllAccounts();

        verify(accountRepository, times(1)).findAll();
        verify(accountMapper, times(1)).toDtoList(accounts);

        assertNotNull(result);
        }

@Test
@Order(4)
void saveAccountTest() {
        AccountDTO accountDTO = new AccountDTO();
        Account account = new Account();

        when(accountMapper.toEntity(accountDTO)).thenReturn(account);
        when(accountRepository.save(account)).thenReturn(account);

        Account result = accountService.saveAccount(accountDTO);

        verify(accountMapper, times(1)).toEntity(accountDTO);
        verify(accountRepository, times(1)).save(account);

        assertNotNull(result);
        }

@Test
@Order(5)
void updateAccountTest() {
        Long accountId = 1L;
        AccountDTO updatedAccountDTO = new AccountDTO();
        Account account = new Account();

        when(accountRepository.findById(accountId)).thenReturn(Optional.of(account));
        when(accountRepository.save(account)).thenReturn(account);

        accountService.updateAccount(accountId, updatedAccountDTO);

        verify(accountRepository, times(1)).findById(accountId);
        verify(accountRepository, times(1)).save(account);
        }

@Test
@Order(6)
void deleteAccountTest() {
        Long accountId = 1L;

        doNothing().when(accountRepository).deleteById(accountId);

        accountService.deleteAccount(accountId);

        verify(accountRepository, times(1)).deleteById(accountId);
        }

@Test
@Order(7)
void getAccountsByCustomerIdTest() {
        Long customerId = 1L;
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(1L);
        accounts.add(account);

        when(accountRepository.findAccountsByCustomer_IdCliente(customerId)).thenReturn(accounts);
        when(accountMapper.toDtoList(accounts)).thenReturn(new ArrayList<>());

        List<AccountDTO> result = accountService.getAccountsByCustomerId(customerId);

        verify(accountRepository, times(1)).findAccountsByCustomer_IdCliente(customerId);
        verify(accountMapper, times(1)).toDtoList(accounts);

        assertNotNull(result);
        }*/
