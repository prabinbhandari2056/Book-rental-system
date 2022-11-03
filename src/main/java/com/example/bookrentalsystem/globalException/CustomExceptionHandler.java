package com.example.bookrentalsystem.globalException;

 public  class CustomExceptionHandler extends Exception{
    public CustomExceptionHandler(String errorString){
        super(errorString);
    }
}