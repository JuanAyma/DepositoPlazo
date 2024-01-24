package com.bbva.costumermicroservice.mapper;

import com.bbva.costumermicroservice.dto.CustomerDTO;
import com.bbva.costumermicroservice.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    List<CustomerDTO> toDtoList(List<Customer> customers);
}
