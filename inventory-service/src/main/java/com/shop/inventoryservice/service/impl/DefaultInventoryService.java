package com.shop.inventoryservice.service.impl;

import com.shop.inventoryservice.client.ProductClient;
import com.shop.inventoryservice.entity.InventoryEntity;
import com.shop.inventoryservice.form.InventoryForm;
import com.shop.inventoryservice.mapper.InventoryMapper;
import com.shop.inventoryservice.repository.InventoryRepository;
import com.shop.inventoryservice.response.InventoryResponse;
import com.shop.inventoryservice.response.ProductResponse;
import com.shop.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultInventoryService implements InventoryService   {

    private final InventoryRepository inventoryRepository;

    private final ProductClient productClient;

    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> getProductsFromInventory(List<Long> productsId) {
        return inventoryRepository.findByProductIdIn(productsId).stream()
                .map(InventoryMapper::toInventoryResponse)
                .toList();
    }

    @Override
    public void addProduct(InventoryForm inventoryForm) {
        ProductResponse product = productClient.getProduct(inventoryForm.getProductName());
        InventoryEntity inventory = InventoryMapper.toEntity(product, inventoryForm);

        inventoryRepository.save(inventory);
    }

}
