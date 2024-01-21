package com.bbva.productmicroservice.repository;

import com.bbva.productmicroservice.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}
