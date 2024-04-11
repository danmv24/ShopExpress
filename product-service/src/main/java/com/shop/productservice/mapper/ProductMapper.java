package com.shop.productservice.mapper;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.model.CategoryEntity;
import com.shop.productservice.model.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(ProductForm productForm, CategoryEntity category) {
        return ProductEntity.builder()
                .productName(productForm.getProductName())
                .category(category)
                .description(productForm.getDescription())
                .price(productForm.getPrice())
                .build();
    }

}