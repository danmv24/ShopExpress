package com.orderservice.service.impl;

import com.orderservice.client.InventoryClient;
import com.orderservice.client.ProductClient;
import com.orderservice.entity.OrderDetailEntity;
import com.orderservice.entity.OrderEntity;
import com.orderservice.form.OrderForm;
import com.orderservice.form.OrderItem;
import com.orderservice.mapper.OrderMapper;
import com.orderservice.repository.OrderDetailRepository;
import com.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderDetailRepository orderDetailRepository;

    private final InventoryClient inventoryClient;

    private final ProductClient productClient;

    /**
     * На будущее
     * {
     *   "items": [
     *     {
     *       "productName": "Яблоки Гренни Смит",
     *       "quantity": 2,
     *       "price": 150
     *     },
     *     {
     *       "productName": "Яблоки Голден",
     *       "quantity": 1,
     *       "price": 1000
     *     }
     *   ],
     *   "payment_method": "Кредитная карта"
     * }
     * */

    @Override
    public void createOrder(OrderForm orderForm) {
        List<String> productNames = orderForm.getOrderItems().stream()
                .map(OrderItem::getProductName)
                .toList();

        List<Long> productsId = productClient.getProductId(productNames);

//        boolean isInStock = inventoryClient.isInStock();

        BigDecimal totalPrice = orderForm.getOrderItems().stream()
                .map(orderItem -> orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        OrderEntity orderEntity = OrderMapper.toOrderEntity(totalPrice, DefaultDateTimeFormatterService.formatDateTime());

        List<OrderDetailEntity> orderDetailEntities = orderForm.getOrderItems().stream()
                .map(orderItem -> OrderMapper.toOrderDetailEntity(orderEntity, orderItem))
                .toList();

        orderDetailRepository.saveAll(orderDetailEntities);
    }

}
