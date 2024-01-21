package com.bbva.interestratemicroservice.service;

import com.bbva.interestratemicroservice.entity.InterestRateEntity;
import com.bbva.interestratemicroservice.repository.InterestRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestRateImpl implements IInterestRateService {
    @Autowired
    private InterestRateRepository interestRateRepository;
    @Override
    public List<InterestRateEntity> findAll() {
        return (List<InterestRateEntity>) interestRateRepository.findAll();
    }

    @Override
    public void save(InterestRateEntity interestRateEntity) {
        interestRateRepository.save(interestRateEntity);
    }

    @Override
    public InterestRateEntity findById(Long id) {
        return interestRateRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        interestRateRepository.deleteById(id);
    }
}
