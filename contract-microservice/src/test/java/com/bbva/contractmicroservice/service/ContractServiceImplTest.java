package com.bbva.contractmicroservice.service;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.entity.Contract;
import com.bbva.contractmicroservice.model.Account;
import com.bbva.contractmicroservice.model.InterestRate;
import com.bbva.contractmicroservice.model.Product;
import com.bbva.contractmicroservice.repository.ContractRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ContractServiceImplTest {

    @Mock
    private ContractRepository contractRepository;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private InterestRateRepository interestRateRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    ContractServiceImpl contractService;


    @Test
    @Order(1)
    void findAll() {
        List<Contract> contracts = new ArrayList<Contract>();

        contracts.add(new Contract(4L, LocalDate.of(2022, 3, 01),
                LocalDate.of(2022, 3, 28), "Origen3",
                "Destino3", BigDecimal.valueOf(3000), null, null, null));
        contracts.add(new Contract(5L, LocalDate.of(2023, 4, 01),
                LocalDate.of(2023, 4, 29), "Origen3",
                "Destino3", BigDecimal.valueOf(5000), null, null, null));

        // Simulando el comportamiento de un objeto real
        when(contractRepository.findAll()).thenReturn(contracts);

        // Llamando al método que se va a probar
        List<Contract> result = contractService.findAll();

        // Verificando que el método findAll del repositorio fue llamado
        verify(contractRepository, times(1)).findAll();

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(contracts.size(), result.size());
        assertEquals(contracts, result);
    }

    @Test
    @Order(2)
    void save() {
        // Crear un contrato de prueba
        Contract contract = new Contract();
        contract.setIdContrato(1L);
        contract.setFechaInicio(LocalDate.of(2022, 3, 01));
        contract.setFechaVencimiento(LocalDate.of(2022, 3, 28));
        contract.setCuentaOrigen("Origen3");
        contract.setCuentaDepositoInte("Destino3");
        contract.setGanancia(BigDecimal.valueOf(3000));

        // Simulando el comportamiento de un objeto real
        when(contractRepository.save(any(Contract.class))).thenReturn(contract);

        // Llamando al método que se va a probar
        contractService.save(contract);

        // Verificando que el método save del repositorio fue llamado
        verify(contractRepository, times(1)).save(any(Contract.class));

    }

    @Test
    @Order(3)
    void findById() {

        Long contractId = 4L;
        Contract contract = new Contract(contractId, LocalDate.of(2022, 3,01),
                LocalDate.of(2022, 3,28), "Origen3",
                "Destino3", BigDecimal.valueOf(3000), null, null,null);

        // Simulando el comportamiento de un objeto real
        when(contractRepository.findById(contractId)).thenReturn(Optional.of(contract));

        // Llamando al método que se va a probar
        Contract result = contractService.findById(contractId);

        // Verificando que el método findById del repositorio fue llamado
        verify(contractRepository, times(1)).findById(contractId);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(contract, result);
    }

    @Test
    @Order(4)
    void findByIdNotFound() {
        Long contractId = 100L;

        // Simulando el comportamiento de un objeto real
        when(contractRepository.findById(contractId)).thenReturn(Optional.empty());

        // Llamando al método que se va a probar y esperando una excepción
        Exception exception = assertThrows(RuntimeException.class, () -> {
            contractService.findById(contractId);
        });

        // Verificando que el método findById del repositorio fue llamado
        verify(contractRepository, times(1)).findById(contractId);

        // Verificando que la excepción tiene el mensaje correcto
        String expectedMessage = "No se encontro el contrato";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(5)
    void deleteById() {
        Long contractId = 4L;

        // Simulando el comportamiento de un objeto real
        doNothing().when(contractRepository).deleteById(contractId);

        // Llamando al método que se va a probar
        contractService.deleteById(contractId);

        // Verificando que el método deleteById del repositorio fue llamado
        verify(contractRepository, times(1)).deleteById(contractId);
    }

    @Test
    @Order(6)
    void createContract() {
        // Crear un ContractDTO con datos de prueba
        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setFechaInicio(LocalDate.of(2022, 3, 01));
        contractDTO.setFechaVencimiento(LocalDate.of(2022, 3, 28));
        contractDTO.setCuentaOrigen("Origen3");
        contractDTO.setCuentaDepositoInte("Destino3");
        contractDTO.setGanancia(BigDecimal.valueOf(3000));
        contractDTO.setIdInteres(1L);
        contractDTO.setIdProducto(1L);
        contractDTO.setIdCuenta(1L);

        // Crear objetos de prueba para InterestRate, Product y Account
        InterestRate interestRate = new InterestRate();
        Product product = new Product();
        Account account = new Account();

        // Crear un contrato de prueba
        Contract contract = new Contract();
        contract.setFechaInicio(contractDTO.getFechaInicio());
        contract.setFechaVencimiento(contractDTO.getFechaVencimiento());
        contract.setCuentaOrigen(contractDTO.getCuentaOrigen());
        contract.setCuentaDepositoInte(contractDTO.getCuentaDepositoInte());
        contract.setGanancia(contractDTO.getGanancia());
        contract.setInterestRate(interestRate);
        contract.setProduct(product);
        contract.setAccount(account);

        // Simulando el comportamiento de un objeto real
        when(interestRateRepository.findById(contractDTO.getIdInteres())).thenReturn(Optional.of(interestRate));
        when(productRepository.findById(contractDTO.getIdProducto())).thenReturn(Optional.of(product));
        when(accountRepository.findById(contractDTO.getIdCuenta())).thenReturn(Optional.of(account));
        when(contractRepository.save(any(Contract.class))).thenReturn(contract);

        // Llamando al método que se va a probar
        Contract result = contractService.createContract(contractDTO);

        // Verificando que los métodos findById y save fueron llamados
        verify(interestRateRepository, times(1)).findById(contractDTO.getIdInteres());
        verify(productRepository, times(1)).findById(contractDTO.getIdProducto());
        verify(accountRepository, times(1)).findById(contractDTO.getIdCuenta());
        verify(contractRepository, times(1)).save(any(Contract.class));

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(contract, result);
    }
}




