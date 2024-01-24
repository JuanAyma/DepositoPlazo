package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.entity.Customer;
import com.bbva.costumermicroservice.repository.CustomerRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceImplTest {
/*
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    @Order(1)
    void findAllTest() {
        // Crear una lista de clientes de prueba
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setIdCliente(1L);
        customers.add(customer1);
        Customer customer2 = new Customer();
        customer2.setIdCliente(2L);
        customers.add(customer2);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findAll()).thenReturn(customers);

        // Llamando al método que se va a probar
        List<Customer> result = customerService.findAll();

        // Verificando que el método findAll del repositorio fue llamado
        verify(customerRepository, times(1)).findAll();

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(customers, result);
    }

    @Test
    @Order(2)
    void saveTest() {
        // Crear un cliente de prueba
        Customer customer = new Customer();
        customer.setIdCliente(1L);

        // Simulando el comportamiento de un objeto real
        doNothing().when(customerRepository).save(customer);

        // Llamando al método que se va a probar
        customerService.save(customer);

        // Verificando que el método save del repositorio fue llamado
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    @Order(3)
    void findByIdTest() {
        // Crear un cliente de prueba
        Long customerId = 1L;
        Customer customer = new Customer();
        customer.setIdCliente(customerId);

        // Simulando el comportamiento de un objeto real
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        // Llamando al método que se va a probar
        Customer result = customerService.findById(customerId);

        // Verificando que el método findById del repositorio fue llamado
        verify(customerRepository, times(1)).findById(customerId);

        // Comparando el resultado esperado con el resultado obtenido
        assertEquals(customer, result);
    }

    @Test
    @Order(4)
    void deleteByIdTest() {
        Long customerId = 1L;

        // Simulando el comportamiento de un objeto real
        doNothing().when(customerRepository).deleteById(customerId);

        // Llamando al método que se va a probar
        customerService.deleteById(customerId);

        // Verificando que el método deleteById del repositorio fue llamado
        verify(customerRepository, times(1)).deleteById(customerId);
    }*/
}