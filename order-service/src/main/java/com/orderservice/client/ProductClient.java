package com.orderservice.client;

import com.orderservice.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "product-service", url = "${products.url}")
public interface ProductClient {

    @GetMapping("/api/products/getProduct")
    List<ProductResponse> getProduct(@RequestParam(name = "productNames") List<String> productNames);

}
