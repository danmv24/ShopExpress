package com.shop.inventoryservice.controller;

import com.shop.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("productId") Long productId ) {
        return inventoryService.isInStock(productId);
    }

}
