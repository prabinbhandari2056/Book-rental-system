package com.example.bookrentalsystem.globalException;

 public  class AppException extends Exception{
    public AppException(String errorString){
        super(errorString);
    }
}