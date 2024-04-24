package com.shop.productservice.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends RuntimeException{

    private String errorMessage;
    private HttpStatus errorCode;

    public CategoryNotFoundException(String errorMessage, HttpStatus errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

}
