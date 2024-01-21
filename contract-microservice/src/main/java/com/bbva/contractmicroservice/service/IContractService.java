package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.entity.ContractEntity;

import java.util.List;

public interface IContractService {
    List<ContractEntity> findAll();
    void save(ContractEntity contratoEntity);
    ContractEntity findById(Long id);
    void deleteById(Long id);
}
