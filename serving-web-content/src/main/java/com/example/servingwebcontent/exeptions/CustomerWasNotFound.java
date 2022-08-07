package com.example.servingwebcontent.exeptions;

public class CustomerWasNotFound extends Exception{
    public CustomerWasNotFound(String message) {
        super(message);
    }
}
