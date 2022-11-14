package com.example.bookrentalsystem.pojo.api;


import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Service
public class ApiResponse {
    private Integer status;

    private String message;

    private Object data;



}
