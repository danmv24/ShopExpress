package com.orderservice.client;

import com.orderservice.response.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "inventory-service", url = "${inventory.url}")
public interface InventoryClient {

    @GetMapping(value = "/api/inventory")
    List<InventoryResponse> getProducts(@RequestParam(name = "productsId") List<Long> productsId);

}
