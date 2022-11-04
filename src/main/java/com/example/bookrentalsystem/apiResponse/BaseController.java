//package com.example.bookrentalsystem.apiResponse;
//
//import lombok.Builder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//
//import java.util.Locale;
//@Builder
//public class BaseController {
//    private Integer status;
//
//    private String message;
//
//    private Object data;
//
//    @Autowired
//    private MessageSource messageSource;
//
//    public BaseController success(String message, Object data) {
//        BaseController response=BaseController.builder()
//                .data(data)
//                .message(message)
//                .status(1)
//                .build();
//        return response;
//    }
//
//    public BaseController error(String message, Object data) {
//        BaseController response=BaseController.builder()
//                .data(data)
//                .message(message)
//                .status(0 )
//                .build();
//        return response;
//    }
//
//    //
//    public String get(String code, Object... param) {
//        return messageSource.getMessage(code, param, Locale.ENGLISH);
//    }
//}
