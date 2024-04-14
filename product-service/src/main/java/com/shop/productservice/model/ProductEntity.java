package com.shop.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subcategory_id")
    private SubcategoryEntity subcategory;

    private float weight;

    private String description;

    private BigDecimal price;

}