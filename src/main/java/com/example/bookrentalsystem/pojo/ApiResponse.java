package com.example.bookrentalsystem.pojo;


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
}
