package com.example.bookrentalsystem.util;

import org.apache.commons.lang3.RandomStringUtils;

public class BookCodeGenerator {
    public String getRandomString(){
        String randomString= RandomStringUtils.randomAlphanumeric(5).toUpperCase();
        return randomString;
    }
    }
