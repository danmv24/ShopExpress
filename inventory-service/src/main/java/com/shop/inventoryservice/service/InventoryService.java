package com.shop.inventoryservice.service;

import com.shop.inventoryservice.response.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> getProductsFromInventory(List<Long> productsId);

}
