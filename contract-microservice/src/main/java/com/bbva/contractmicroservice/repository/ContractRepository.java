package com.bbva.contractmicroservice.repository;

import com.bbva.contractmicroservice.entity.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long>{
}
