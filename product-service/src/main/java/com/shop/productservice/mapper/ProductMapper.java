package com.shop.productservice.mapper;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.model.CategoryEntity;
import com.shop.productservice.model.ProductEntity;
import com.shop.productservice.model.SubcategoryEntity;
import com.shop.productservice.view.ProductView;

public class ProductMapper {

    public static ProductEntity toEntity(ProductForm productForm, CategoryEntity category, SubcategoryEntity subcategory) {
        return ProductEntity.builder()
                .productName(productForm.getProductName())
                .category(category)
                .subcategory(subcategory)
                .weight(productForm.getWeight())
                .description(productForm.getDescription())
                .price(productForm.getPrice())
                .build();
    }

    public static ProductView toView(ProductEntity product) {
        return ProductView.builder()
                .productName(product.getProductName())
                .categoryName(product.getCategory().getCategoryName())
                .subcategoryName(product.getSubcategory().getSubcategoryName())
                .weight(product.getWeight())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}