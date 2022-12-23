package com.example.demo.controller;

import com.example.demo.dto.EmpDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exception.GenralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException ex){
        String message = ex.getMessage();

        ResponseDTO responseDTO = new ResponseDTO("TEST_500", message);
        return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity genralException(GenralException gExcep){
        String message = gExcep.getMessage();
        String code = gExcep.getStatusCode();
        Object errorMessage = gExcep.getErroMessages();

        ResponseDTO responseDTO = new ResponseDTO("FALURE", code, message, errorMessage);
        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
