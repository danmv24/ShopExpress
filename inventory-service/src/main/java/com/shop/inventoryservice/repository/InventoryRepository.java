package com.shop.inventoryservice.repository;

import com.shop.inventoryservice.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryEntity, Long> {

    Optional<InventoryEntity> findByProductId(Long productId);

}
