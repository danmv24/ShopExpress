package com.orderservice.controller;

import com.orderservice.form.OrderForm;
import com.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<String> createOrder(@RequestBody OrderForm orderForm) {
        return CompletableFuture.supplyAsync(() -> orderService.createOrder(orderForm));
    }

    public CompletableFuture<String> fallbackMethod(OrderForm orderForm, RuntimeException runtimeException) {
         return CompletableFuture.supplyAsync(() -> "Упс! Что-то пошло не так. Пожалуйста, сделайте заказ чуточку позже!" );
    }

}
