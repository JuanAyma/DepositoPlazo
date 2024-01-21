package com.bbva.interestratemicroservice.service;

import com.bbva.interestratemicroservice.entity.InterestRateEntity;

import java.util.List;

public interface IInterestRateService {

        public List<InterestRateEntity> findAll();
        public void save(InterestRateEntity tasaInteresEntity);
        public InterestRateEntity findById(Long id);
        public void deleteById(Long id);
}
