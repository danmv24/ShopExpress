package com.orderservice.service.impl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DefaultDateTimeFormatterService {

    public static LocalDateTime formatDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = currentDateTime.format(formatter);

        return LocalDateTime.parse(formattedDateTime, formatter);
    }

}
