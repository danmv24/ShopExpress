package com.shop.inventoryservice.service.impl;

import com.shop.inventoryservice.repository.InventoryRepository;
import com.shop.inventoryservice.response.InventoryResponse;
import com.shop.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultInventoryService implements InventoryService   {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> getProductsFromInventory(List<Long> productsId) {
        return inventoryRepository.findByProductIdIn(productsId).stream()
                .map(inventoryEntity -> InventoryResponse.builder()
                        .productId(inventoryEntity.getProductId())
                        .quantity(inventoryEntity.getQuantity())
                        .build())
                .toList();
    }

}
