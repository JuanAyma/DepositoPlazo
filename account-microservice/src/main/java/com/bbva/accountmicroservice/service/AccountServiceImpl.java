package com.bbva.accountmicroservice.service;

import com.bbva.accountmicroservice.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bbva.accountmicroservice.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountEntity> findAll() {
        return (List<AccountEntity>) accountRepository.findAll();
    }

    @Override
    public void save(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }


    @Override
    public AccountEntity findById(Long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
