package com.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "products", url = "${products.url}")
public interface ProductClient {

    @GetMapping("/api/products/getProductId")
    List<Long> getProductId(@RequestParam(name = "productNames") List<String> productNames);

}
