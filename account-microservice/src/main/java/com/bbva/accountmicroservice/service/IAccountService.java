package com.bbva.accountmicroservice.service;

import com.bbva.accountmicroservice.dto.AccountCreateDTO;
import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;

import java.util.List;

public interface IAccountService {
    /*List<AccountDTO> findAll();
    void save(Account account);
    AccountDTO findById(Long id);
    void deleteById(Long id);*/

    AccountDTO getAccountById(Long accountId);
    List<AccountDTO> getAllAccounts();
    Account saveAccount(AccountDTO accountDTO);
    void updateAccount(Long accountId, AccountDTO updatedAccountDTO);
    void deleteAccount(Long accountId);

    ////////////////////////////////////////////////////////////////////
    List<AccountDTO> getAccountsByCustomerId(Long customerId);
}
