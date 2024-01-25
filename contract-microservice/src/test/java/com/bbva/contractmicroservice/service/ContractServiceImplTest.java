package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.entity.Contract;
import com.bbva.contractmicroservice.mapper.ContractMapper;
import com.bbva.contractmicroservice.repository.ContractRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContractServiceImplTest {

    @Mock// Mock es una clase que simula el comportamiento de un objeto real
    ContractRepository contractRepository;
    @Mock
    ContractMapper contractMapper;
    @InjectMocks // Inyecta los mocks como dependencias de customerService
    ContractServiceImpl contractService;

    @Test
    @Order(1)
    void findAllTest() {
        // Crear una lista de contratos de prueba
        List<Contract> contracts = new ArrayList<>();
        Contract contract1 = new Contract();
        contract1.setIdContrato(1L);
        contracts.add(contract1);
        Contract contract2 = new Contract();
        contract2.setIdContrato(2L);
        contracts.add(contract2);

        // Crear una lista de contratos DTO de prueba
        List<ContractDTO> contractDTOs = new ArrayList<>();
        ContractDTO contractDTO1 = new ContractDTO();
        contractDTO1.setIdContrato(1L);
        contractDTOs.add(contractDTO1);
        ContractDTO contractDTO2 = new ContractDTO();
        contractDTO2.setIdContrato(2L);
        contractDTOs.add(contractDTO2);

        // Simulando el comportamiento de un objeto real
        when(contractRepository.findAll()).thenReturn(contracts);
        when(contractMapper.toDtoList(contracts)).thenReturn(contractDTOs);

        // Llamando al método que se va a probar
        List<ContractDTO> result = contractService.findAll();

        // Verificando que el método findAll del repositorio fue llamado
        verify(contractRepository, times(1)).findAll();

        // Verificando que el método toDtoList del mapper fue llamado
        verify(contractMapper, times(1)).toDtoList(contracts);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(contractDTOs, result);
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }
}