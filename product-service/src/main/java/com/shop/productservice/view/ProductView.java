package com.shop.productservice.view;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductView {

    private String productName;

    private String categoryName;

    private String description;

    private BigDecimal price;

}
