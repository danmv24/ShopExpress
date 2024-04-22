package com.orderservice.service.impl;

import com.orderservice.entity.OrderEntity;
import com.orderservice.form.OrderForm;
import com.orderservice.mapper.OrderMapper;
import com.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrderService implements OrderService {

    @Override
    public void createOrder(OrderForm orderForm) {
        List<OrderEntity> orderEntities = orderForm.getOrderItems().stream()
                .map(OrderMapper::toOrderEntity)
                .toList();

    }

}
