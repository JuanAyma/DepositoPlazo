package com.bbva.accountmicroservice.service;

import com.bbva.accountmicroservice.dto.AccountCreateDTO;
import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;
import com.bbva.accountmicroservice.mapper.AccountCreateMapper;
import com.bbva.accountmicroservice.mapper.AccountMapper;
import com.bbva.accountmicroservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final AccountCreateMapper accountCreateMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, RestTemplate restTemplate, AccountCreateMapper accountCreateMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.restTemplate = restTemplate;
        this.accountCreateMapper = accountCreateMapper;
    }
//-----------------------------METODOS CRUD-----------------------
    //BUSCAR POR ID
    @Override
    @Transactional(readOnly = true)
    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con ID: " + accountId));
        return accountMapper.toDto(account);
    }

    //LISTAR TODOS
    @Override
    @Transactional(readOnly = true)
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        return accountMapper.toDtoList(accounts);
    }

    //CREAR
    @Override
    @Transactional
    public Account saveAccount(AccountDTO accountDTO) {
        Account accountEntity = accountMapper.toEntity(accountDTO);
        return accountRepository.save(accountEntity);
    }

    //ACTUALIZAR
    @Override
    public void updateAccount(Long accountId, AccountDTO updatedAccountDTO) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setSaldo(updatedAccountDTO.getSaldo());
            account.setFechaApertura(updatedAccountDTO.getFechaApertura());
            account.setEstadoCuenta(updatedAccountDTO.getEstadoCuenta());
            accountRepository.save(account);
        }
    }

    //ELIMINAR
    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    /////////////////////////////////////////////////////////////
    @Override
    @Transactional(readOnly = true)
    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        List<Account> accounts = accountRepository.findAccountsByCustomer_IdCliente(customerId);
        return accountMapper.toDtoList(accounts);
    }
   /* @Override
    public Account createAccount(AccountDTO accountDTO) {
        Account account = new Account();

        account.setSaldo(accountDTO.getSaldo());
        account.setFechaApertura(accountDTO.getFechaApertura());
        account.setEstadoCuenta(accountDTO.getEstadoCuenta());

        Customer customer = customerRepository.findById(accountDTO.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + accountDTO.getIdCliente()));
        account.setCustomer(customer);

        Currency currency = currencyRepository.findById(accountDTO.getIdMoneda())
                .orElseThrow(() -> new RuntimeException("Moneda no encontrada con ID: " + accountDTO.getIdMoneda()));
        account.setCurrency(currency);

        return accountRepository.save(account);
    }*/
}
