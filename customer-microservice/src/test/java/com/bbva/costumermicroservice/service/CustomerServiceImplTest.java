package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.dto.CustomerDTO;
import com.bbva.costumermicroservice.entity.Customer;
import com.bbva.costumermicroservice.mapper.CustomerMapper;
import com.bbva.costumermicroservice.model.Account;
import com.bbva.costumermicroservice.repository.CustomerRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    @Order(1)
    void getCustomerByIdTest() {
        // Crear un customerId de prueba
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setIdCliente(customerId);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdCliente(customerId);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerMapper.toDto(customer)).thenReturn(customerDTO);

        // Llamando al método que se va a probar
        CustomerDTO result = customerService.getCustomerById(customerId);

        // Verificando que los métodos del repositorio y del mapper fueron llamados
        verify(customerRepository, times(1)).findById(customerId);
        verify(customerMapper, times(1)).toDto(customer);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(customerDTO, result);
    }

    @Test
    @Order(2)
    void getAllCustomersTest() {
        // Crear una lista de clientes de prueba
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setIdCliente(1L);
        customers.add(customer1);
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        CustomerDTO customerDTO1 = new CustomerDTO();
        customerDTO1.setIdCliente(1L);
        customerDTOs.add(customerDTO1);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findAll()).thenReturn(customers);
        when(customerMapper.toDtoList(customers)).thenReturn(customerDTOs);

        // Llamando al método que se va a probar
        List<CustomerDTO> result = customerService.getAllCustomers();

        // Verificando que los métodos del repositorio y del mapper fueron llamados
        verify(customerRepository, times(1)).findAll();
        verify(customerMapper, times(1)).toDtoList(customers);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(customerDTOs, result);
    }

    @Test
    @Order(3)
    void saveCustomer() {
        // Crear un customerDTO de prueba
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdCliente(1L);
        Customer customer = new Customer();
        customer.setIdCliente(1L);

        // Simulando el comportamiento de un objeto real
        when(customerMapper.toEntity(customerDTO)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);

        // Llamando al método que se va a probar
        customerService.saveCustomer(customerDTO);

        // Verificando que los métodos del repositorio y del mapper fueron llamados con los argumentos correctos
        verify(customerMapper, times(1)).toEntity(customerDTO);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    @Order(4)
    void updateCustomer() {
        // Crear un customerId y un updatedCustomer de prueba
        Long customerId = 1L;
        CustomerDTO updatedCustomerDTO = new CustomerDTO();
        updatedCustomerDTO.setIdCliente(customerId);
        updatedCustomerDTO.setNombre("Updated Name");
        Customer existingCustomer = new Customer();
        existingCustomer.setIdCliente(customerId);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Llamando al método que se va a probar
        customerService.updateCustomer(customerId, updatedCustomerDTO);

        // Verificando que los métodos del repositorio fueron llamados
        verify(customerRepository, times(1)).findById(customerId);
        verify(customerRepository, times(1)).save(existingCustomer);

        // Verificando que el nombre del cliente existente fue actualizado
        assertEquals(updatedCustomerDTO.getNombre(), existingCustomer.getNombre());
    }

    @Test
    @Order(5)
    void deleteCustomer() {
        // Crear un customerId de prueba
        Long customerId = 1L;

        // Simulando el comportamiento de un objeto real
        doNothing().when(customerRepository).deleteById(customerId);

        // Llamando al método que se va a probar
        customerService.deleteCustomer(customerId);

        // Verificando que el método deleteById del repositorio fue llamado
        verify(customerRepository, times(1)).deleteById(customerId);
    }

    @Test
    @Order(6)
    void getAccountsByCustomerId() {
        // Crear un customerId de prueba
        Long customerId = 1L;

        // Crear una lista de cuentas de prueba
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account();
        account1.setIdCuenta(1L);
        accounts.add(account1);

        // Simulando el comportamiento de un objeto real
        when(restTemplate.getForObject("http://localhost:9081/api/account/customer/" + customerId + "/accounts", List.class)).thenReturn(accounts);

        // Llamando al método que se va a probar
        List<Account> result = customerService.getAccountsByCustomerId(customerId);

        // Verificando que el método del restTemplate fue llamado
        verify(restTemplate, times(1)).getForObject("http://localhost:9081/api/account/customer/" + customerId + "/accounts", List.class);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(accounts, result);
    }
}