package com.orderservice.controller;

import com.orderservice.form.OrderForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    public String createOrder(@RequestBody OrderForm orderForm) {
        return "Заказ обрабатывается";
    }

}
