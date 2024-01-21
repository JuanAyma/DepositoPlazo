package com.bbva.productmicroservice.service;

import com.bbva.productmicroservice.entity.ProductEntity;
import com.bbva.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    @Override
    public void save(ProductEntity productEntity) {
       productRepository.save(productEntity);
    }

    @Override
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
