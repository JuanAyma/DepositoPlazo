package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.model.Account;
import com.bbva.contractmicroservice.entity.Contract;
import com.bbva.contractmicroservice.model.InterestRate;
import com.bbva.contractmicroservice.model.Product;
import com.bbva.contractmicroservice.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {


    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private InterestRateRepository interestRateRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
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
    }


}
