package com.bbva.costumermicroservice.service;

import com.bbva.costumermicroservice.dto.CustomerDTO;
import com.bbva.costumermicroservice.model.Account;

import java.util.List;

public interface ICustomerService {

    CustomerDTO getCustomerById(Long customerId);

    List<CustomerDTO> getAllCustomers();

    void saveCustomer(CustomerDTO customer);

    void updateCustomer(Long customerId, CustomerDTO updatedCustomer);

    void deleteCustomer(Long customerId);
///////////////////////////////////////////////////////////////////////////
/*    CustomerDTO getCustomerById(Long customerId);*/
    List<Account> getAccountsByCustomerId(Long customerId);
}
