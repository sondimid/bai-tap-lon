package com.example.btnjava.CustomException;

public class InvalidParamException extends Exception{
    public InvalidParamException(String message) {
        super(message);
    }
}
