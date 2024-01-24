package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.dto.CustomerDTO;
import com.bbva.costumermicroservice.entity.Customer;
import com.bbva.costumermicroservice.mapper.CustomerMapper;
import com.bbva.costumermicroservice.model.Account;
import com.bbva.costumermicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final RestTemplate restTemplate;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toDto(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return customerMapper.toDtoList(customers);
    }

    @Override
    @Transactional
    public void saveCustomer(CustomerDTO customer) {
        Customer customerEntity = customerMapper.toEntity(customer);
        customerRepository.save(customerEntity);
    }

    @Override
    @Transactional
    public void updateCustomer(Long customerId, CustomerDTO updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.ifPresent((existingCustomer) -> {
            existingCustomer.setNombre(updatedCustomer.getNombre());
            existingCustomer.setApellido(updatedCustomer.getApellido());
            existingCustomer.setCelular(updatedCustomer.getCelular());
            existingCustomer.setDni(updatedCustomer.getDni());
            existingCustomer.setDireccion(updatedCustomer.getDireccion());
            existingCustomer.setCorreo(updatedCustomer.getCorreo());
            customerRepository.save(existingCustomer);
        });
    }

    @Override
    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Account> getAccountsByCustomerId(Long customerId) {
        List<Account> accounts = restTemplate.getForObject("http://localhost:8080/api/account/customer/" + customerId + "/accounts", List.class);
        return accounts;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
/*    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        String customerServiceEndpoint = "http://localhost:8082/api/customer/" + customerId;
        return restTemplate.getForObject(customerServiceEndpoint, CustomerDTO.class);
    }

    @Override
    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        String customerServiceEndpoint = "http://localhost:8082/api/customer/" + customerId + "/accounts";
        AccountDTO[] accounts = restTemplate.getForObject(customerServiceEndpoint, AccountDTO[].class);
        return Arrays.asList(accounts);
    }*/
}
