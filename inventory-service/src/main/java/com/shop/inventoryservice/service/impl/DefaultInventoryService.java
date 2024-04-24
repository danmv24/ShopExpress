package com.shop.inventoryservice.service.impl;

import com.shop.inventoryservice.repository.InventoryRepository;
import com.shop.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DefaultInventoryService implements InventoryService   {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(Long productId) {
        return inventoryRepository.findByProductId(productId).isPresent();
    }

}
