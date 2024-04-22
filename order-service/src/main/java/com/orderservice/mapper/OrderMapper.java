package com.orderservice.mapper;

import com.orderservice.entity.OrderEntity;
import com.orderservice.form.OrderItem;
import com.orderservice.service.impl.DefaultDateTimeFormatterService;

import java.time.LocalDateTime;

public class OrderMapper {

    public static OrderEntity toOrderEntity(OrderItem orderItem) {
        return OrderEntity.builder()
                .orderDate(LocalDateTime.parse(DefaultDateTimeFormatterService.formatDateTime()))
                .build();
    }

}
