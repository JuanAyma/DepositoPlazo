package com.bbva.interestratemicroservice.repository;


import com.bbva.interestratemicroservice.entity.InterestRateEntity;
import org.springframework.data.repository.CrudRepository;

public interface InterestRateRepository extends CrudRepository<InterestRateEntity, Long> {
}
