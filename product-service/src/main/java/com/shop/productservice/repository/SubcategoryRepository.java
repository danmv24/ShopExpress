package com.shop.productservice.repository;

import com.shop.productservice.model.SubcategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends CrudRepository<SubcategoryEntity, Long> {

    Optional<SubcategoryEntity> findBySubcategoryName(String subcategoryName);

}
