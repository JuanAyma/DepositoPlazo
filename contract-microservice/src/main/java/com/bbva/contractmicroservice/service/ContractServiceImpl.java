package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.entity.ContractEntity;
import com.bbva.contractmicroservice.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {


    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<ContractEntity> findAll() {
        return (List<ContractEntity>) contractRepository.findAll();
    }

    @Override
    public void save(ContractEntity contractEntity) {
        contractRepository.save(contractEntity);
    }

    @Override
    public ContractEntity findById(Long id) {
        return contractRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);

    }
}
