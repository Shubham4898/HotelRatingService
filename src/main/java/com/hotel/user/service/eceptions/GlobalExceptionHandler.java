package com.hotel.user.service.eceptions;

import com.hotel.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.lang.Boolean.TRUE;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse>  handleResourceNotFoundException(ResourceNotFoundException ex){

        String message = ex.getMessage();

        ApiResponse response =  ApiResponse.builder().message(message).success(TRUE).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
