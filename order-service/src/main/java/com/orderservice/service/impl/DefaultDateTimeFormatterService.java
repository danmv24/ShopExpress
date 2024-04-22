package com.orderservice.service.impl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;

@Service
public class DefaultDateTimeFormatterService {

    public static String formatDateTime() {
        // Создаем форматировщик даты и времени
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("dd-MM-yyyy HH:mm:ss")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);

        // Получаем текущую дату и время
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Преобразуем дату и время в строку в соответствии с заданным форматом
        return currentDateTime.format(formatter);
    }

}
