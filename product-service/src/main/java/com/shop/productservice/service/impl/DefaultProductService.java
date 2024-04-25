package com.shop.productservice.service.impl;

import com.shop.productservice.exception.CategoryNotFoundException;
import com.shop.productservice.exception.SubcategoryNotFoundException;
import com.shop.productservice.form.ProductForm;
import com.shop.productservice.mapper.ProductMapper;
import com.shop.productservice.model.CategoryEntity;
import com.shop.productservice.model.ProductEntity;
import com.shop.productservice.model.SubcategoryEntity;
import com.shop.productservice.repository.CategoryRepository;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.repository.SubcategoryRepository;
import com.shop.productservice.service.ProductService;
import com.shop.productservice.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final SubcategoryRepository subcategoryRepository;

    @Override
    public void addProduct(ProductForm productForm) {
        CategoryEntity category = categoryRepository.findByCategoryName(productForm.getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException("Категория с названием " + productForm.getCategoryName() + "не существует!!!", HttpStatus.NOT_FOUND));
        SubcategoryEntity subcategory = subcategoryRepository.findBySubcategoryName(productForm.getSubcategoryName())
                .orElseThrow(() -> new SubcategoryNotFoundException("Подкатегория с названием " + productForm.getSubcategoryName() + "не существует!!!", HttpStatus.NOT_FOUND));

        productRepository.save(ProductMapper.toEntity(productForm, category, subcategory));
    }

    @Override
    public List<ProductView> getProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(ProductMapper::toView).collect(Collectors.toList());
    }

    @Override
    public List<Long> getProductIdViaProductName(List<String> productNames) {
        return productNames.stream()
                .map(productRepository::findIdByProductName)
                .toList();
    }


}
