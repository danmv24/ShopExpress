package com.orderservice.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponse {

    private Long productId;
    private int quantity;

}
