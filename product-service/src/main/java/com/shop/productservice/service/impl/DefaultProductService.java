package com.shop.productservice.service.impl;

import com.shop.productservice.form.ProductForm;
import com.shop.productservice.mapper.ProductMapper;
import com.shop.productservice.model.CategoryEntity;
import com.shop.productservice.model.ProductEntity;
import com.shop.productservice.repository.CategoryRepository;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.service.ProductService;
import com.shop.productservice.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public void addProduct(ProductForm productForm) {
        CategoryEntity categoryEntity = categoryRepository.findByCategoryName(productForm.getCategoryName()).orElseThrow();

        productRepository.save(ProductMapper.toEntity(productForm, categoryEntity));
    }

    @Override
    public List<ProductView> getProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String categoryName = String.valueOf(categoryRepository.findByCategoryName(product.getCategory().getCategoryName()));
                });
    }


}
