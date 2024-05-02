package com.shop.productservice.repository;

import com.shop.productservice.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    List<ProductEntity> findByProductNameIn(List<String> productName);

}
