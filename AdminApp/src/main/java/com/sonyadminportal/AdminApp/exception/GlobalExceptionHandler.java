package com.sonyadminportal.AdminApp.exception;

import com.sonyadminportal.AdminApp.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidBrandException.class)
    public ResponseEntity<ErrorModel> InvalidBrandException(InvalidBrandException invalidBrandException)
    {
        ErrorModel errorModel=ErrorModel.builder().errorCode("error 001")
                .errorMessage(invalidBrandException.getMessage()).build();
        return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
    }

}
