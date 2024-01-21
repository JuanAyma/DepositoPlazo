package com.bbva.productmicroservice.service;

import com.bbva.productmicroservice.entity.ProductEntity;

import java.util.List;

public interface IProductService {

    public List<ProductEntity> findAll();
    public void save(ProductEntity productEntity);
    public ProductEntity findById(Long id);
    public void deleteById(Long id);

}
