package com.orderservice.mapper;

import com.orderservice.entity.OrderDetailEntity;
import com.orderservice.entity.OrderEntity;
import com.orderservice.form.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderMapper {

    public static OrderEntity toOrderEntity(BigDecimal totalPrice, LocalDateTime date) {
        return OrderEntity.builder()
                .totalPrice(totalPrice)
                .orderDate(date)
                .build();
    }

    public static OrderDetailEntity toOrderDetailEntity(OrderEntity order, OrderItem orderItem) {
        return OrderDetailEntity.builder()
                .order(order)
                .productId(1L)
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getPrice())
                .build();
    }

}
