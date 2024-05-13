package com.shop.inventoryservice.repository;

import com.shop.inventoryservice.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends CrudRepository<InventoryEntity, Long> {

    List<InventoryEntity> findByProductIdIn(List<Long> productsId);

    Optional<InventoryEntity> findByProductId(Long id);

}
