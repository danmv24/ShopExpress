package com.shop.productservice.controller;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.service.ProductService;
import com.shop.productservice.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/getProductId")
    @Transactional(readOnly = true)
    public List<Long> getProductIdViaProductName(@RequestParam(name = "productNames") List<String> productNames) {
        return productService.getProductIdViaProductName(productNames);
    }

}
