package com.shop.productservice.controller;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.response.ProductResponse;
import com.shop.productservice.service.ProductService;
import com.shop.productservice.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductForm productForm) {
        productService.addProduct(productForm);
    }

    @GetMapping
    public List<ProductView> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getProducts")
    public List<ProductResponse> getProductsByNames(@RequestParam(name = "productNames") List<String> productNames) {
        return productService.getProductsByProductNames(productNames);
    }

    @GetMapping("/getProduct")
    public ProductResponse getProduct(@RequestParam(name = "productName") String productName) {
        return productService.getProduct(productName);
    }

}
