package com.bbva.contractmicroservice.repository;

import com.bbva.contractmicroservice.entity.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<ContractEntity, Long>{
}
