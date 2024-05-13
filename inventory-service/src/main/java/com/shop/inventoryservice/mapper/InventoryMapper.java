package com.shop.inventoryservice.mapper;

import com.shop.inventoryservice.entity.InventoryEntity;
import com.shop.inventoryservice.form.InventoryForm;
import com.shop.inventoryservice.response.InventoryResponse;
import com.shop.inventoryservice.response.ProductResponse;

public class InventoryMapper {

    public static InventoryResponse toInventoryResponse(InventoryEntity inventory) {
        return InventoryResponse.builder()
                .productId(inventory.getProductId())
                .quantity(inventory.getQuantity())
                .build();
    }

    public static InventoryEntity toEntity(ProductResponse product, InventoryForm inventoryForm) {
        return InventoryEntity.builder()
                .productId(product.getId())
                .quantity(inventoryForm.getQuantity())
                .build();
    }

}
