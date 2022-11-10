package com.example.bookrentalsystem.globalException;

import com.example.bookrentalsystem.pojo.api.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ApiResponse handleUniqueViolation(ConstraintViolationException ex) {
        if (ex.getConstraintName().contains("unique")) {
            // unique_user_name
            String unique = ex.getConstraintName().replace("unique_", "");
            return ApiResponse.builder().data(null).message(unique + " already exists").status(1).build();
        }
        return null;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ApiResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ApiResponse.builder().data(null).message(ex.getCause().getCause().getLocalizedMessage()).status(1).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handelMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ApiResponse.builder().data(null).message((Objects.requireNonNull(ex.getFieldError()).getDefaultMessage())).status(1).build();
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse handleAllException(Exception ex) {
        return ApiResponse.builder().data(null).message(ex.getMessage()).status(1).build();
    }
}