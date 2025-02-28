package com.oms.officeManagement.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException customException) {

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("Error Code", customException.getStatusCode());
        errorResponse.put("Error message", customException.getErrorMessage());
        errorResponse.put("Error Status", customException.getStatus());
        errorResponse.put("Error duration", customException.getDuration());

        return new ResponseEntity<>(errorResponse,customException.getStatus());
    }
}