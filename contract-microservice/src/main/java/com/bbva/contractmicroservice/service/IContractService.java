package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.entity.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    void save(Contract contrato);
    Contract findById(Long id);
    void deleteById(Long id);
/////////////////////////////////////////////////////
    Contract createContract(ContractDTO contractDTO);
}
