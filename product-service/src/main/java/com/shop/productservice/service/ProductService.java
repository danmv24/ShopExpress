package com.shop.productservice.service;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.response.ProductResponse;
import com.shop.productservice.view.ProductView;

import java.util.List;

public interface ProductService {

    void addProduct(ProductForm productForm);

    List<ProductView> getProducts();

    List<ProductResponse> getProductByProductName(List<String> productNames);

}
