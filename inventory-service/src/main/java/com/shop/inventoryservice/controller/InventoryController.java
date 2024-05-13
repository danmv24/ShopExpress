package com.shop.inventoryservice.controller;

import com.shop.inventoryservice.form.InventoryForm;
import com.shop.inventoryservice.response.InventoryResponse;
import com.shop.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getProducts(@RequestParam(name = "productsId") List<Long> productsId) {
        return inventoryService.getProductsFromInventory(productsId);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductInInventory(InventoryForm inventoryForm) {
        inventoryService.addProduct(inventoryForm);
    }

}
