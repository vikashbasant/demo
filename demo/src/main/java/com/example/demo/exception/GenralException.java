package com.example.demo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GenralException extends Exception{

    private String statusCode;
    private String message;
    private transient Object erroMessages;


    public GenralException(String errorCode, String message, String erroMessages){
        this.statusCode = errorCode;
        this.message = message;
        this.erroMessages = erroMessages;
    }

    public GenralException(String errorCode, String message){
        this.statusCode = errorCode;
        this.message = message;
    }

}
