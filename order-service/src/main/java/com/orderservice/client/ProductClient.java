package com.orderservice.client;

import com.orderservice.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product-service")
public interface ProductClient {

    @GetMapping("/api/products/getProducts")
    List<ProductResponse> getProductsByNames(@RequestParam(name = "productNames") List<String> productNames);

}
