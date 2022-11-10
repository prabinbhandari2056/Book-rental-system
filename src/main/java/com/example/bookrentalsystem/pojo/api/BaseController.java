package com.example.bookrentalsystem.pojo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class BaseController {
    private Integer status;

    private String message;

    private Object data;

    @Autowired
    private MessageSource messageSource;



    public ApiResponse success(String message, Object data) {
        ApiResponse response=ApiResponse.builder()
                .data(data)
                .message(message)
                .status(1)
                .build();
        return response;
    }

    public ApiResponse error(String message, Object data) {
        ApiResponse response=ApiResponse.builder()
                .data(data)
                .message(message)
                .status(0 )
                .build();
        return response;
    }

    //
    public String get(String code, Object... param) {
        return messageSource.getMessage(code, param, Locale.ENGLISH);
    }
}
