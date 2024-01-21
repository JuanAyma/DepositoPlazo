package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.entity.CustomerEntity;

import java.util.List;

public interface ICustomerService {

    public List<CustomerEntity> findAll();
    public void save(CustomerEntity customerEntity);
    public CustomerEntity findById(Long id);
    public void deleteById(Long id);
}
