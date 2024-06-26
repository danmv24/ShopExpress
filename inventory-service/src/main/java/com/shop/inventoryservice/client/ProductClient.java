package com.shop.inventoryservice.client;

import com.shop.inventoryservice.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/api/products/product")
    ProductResponse getProduct(@RequestParam(name = "productName") String productName);

}
