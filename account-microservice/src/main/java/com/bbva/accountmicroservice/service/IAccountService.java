package com.bbva.accountmicroservice.service;

import com.bbva.accountmicroservice.entity.AccountEntity;

import java.util.List;

public interface IAccountService {
    List<AccountEntity> findAll();
    void save(AccountEntity accountEntity);
    AccountEntity findById(Long id);
    void deleteById(Long id);
}
