package com.shop.inventoryservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Long productId;

    private String productName;

}
