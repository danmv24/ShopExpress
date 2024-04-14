package com.shop.productservice.form;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductForm {

    private String productName;

    private String categoryName;

    private String subcategoryName;

    private float weight;

    private String description;

    private BigDecimal price;

}
