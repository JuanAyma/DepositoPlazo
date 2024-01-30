package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.mapper.ContractMapper;
import com.bbva.contractmicroservice.entity.Contract;
import com.bbva.contractmicroservice.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, ContractMapper contractMapper) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
    }

    //-----------------------------METODOS CRUD-----------------------
    //LISTAR TODOS CONTRATOS
    @Override
    @Transactional(readOnly = true)
    public List<ContractDTO> findAll() {
        List<Contract> contracts = (List<Contract>) contractRepository.findAll();
        return contractMapper.toDtoList(contracts);
    }
    //CREAR UN NUEVO CONTRATO
    @Override
    @Transactional
    public Contract save(ContractDTO contrato) {
        Contract contractEntity = contractMapper.toEntity(contrato);
        return contractRepository.save(contractEntity);
    }
    //BUSCAR POR ID DE UN CONTRATO
    @Override
    @Transactional(readOnly = true)
    public ContractDTO findById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el contrato con id: " + id));
        return contractMapper.toDto(contract);
    }
    //ELIMINAR UN CONTRATO
    @Override
    @Transactional
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }
}
