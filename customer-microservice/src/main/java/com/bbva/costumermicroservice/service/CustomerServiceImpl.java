package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.entity.CustomerEntity;
import com.bbva.costumermicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return (List<CustomerEntity>) customerRepository.findAll();
    }

    @Override
    public void save(CustomerEntity customerEntity) {
        customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);

    }
}
