package com.shop.productservice.service;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.response.ProductResponse;
import com.shop.productservice.view.ProductView;

import java.util.List;

public interface ProductService {

    void addProduct(ProductForm productForm);

    List<ProductView> getAllProducts();

    List<ProductResponse> getProductsByProductNames(List<String> productNames);

    ProductResponse getProduct(String productName);
}
