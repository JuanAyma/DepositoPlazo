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
    //LISTAR TODOS
    @Override
    @Transactional(readOnly = true)
    public List<ContractDTO> findAll() {
        List<Contract> contracts = (List<Contract>) contractRepository.findAll();
        return contractMapper.toDtoList(contracts);
    }
    //CREAR
    @Override
    @Transactional
    public Contract save(ContractDTO contrato) {
        Contract contractEntity = contractMapper.toEntity(contrato);
        return contractRepository.save(contractEntity);
    }
    //BUSCAR POR ID
    @Override
    @Transactional(readOnly = true)
    public ContractDTO findById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el contrato con id: " + id));
        return contractMapper.toDto(contract);
    }
    //ELIMINAR
    @Override
    @Transactional
    public void deleteById(Long id) {
        contractRepository.deleteById(id);
    }


    /*@Override
    public List<Contract> findAll() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el contrato"));
    }

    @Override
    public void deleteById(Long id) {
        contractRepository.deleteById(id);

    }

    @Override
    public Contract createContract(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setFechaInicio(contractDTO.getFechaInicio());
        contract.setFechaVencimiento(contractDTO.getFechaVencimiento());
        contract.setCuentaOrigen(contractDTO.getCuentaOrigen());
        contract.setCuentaDepositoInte(contractDTO.getCuentaDepositoInte());
        contract.setGanancia(contractDTO.getGanancia());

        InterestRate interestRate = interestRateRepository.findById(contractDTO.getIdInteres()).orElseThrow();
        contract.setInterestRate(interestRate);

        Product product = productRepository.findById(contractDTO.getIdProducto()).orElseThrow();
        contract.setProduct(product);

        Account account = accountRepository.findById(contractDTO.getIdCuenta()).orElseThrow();
        contract.setAccount(account);

        return contractRepository.save(contract);
    }*/
}
