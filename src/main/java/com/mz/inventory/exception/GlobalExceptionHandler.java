package com.mz.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GlobalExceptionHandler {
    //1 ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(ResourceNotFoundException exp) {
        Map<String,String> map = new HashMap<>();
        map.put("message", exp.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    // 2 Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException exp) {
        Map<String,String> map = new HashMap<>();
        exp.getBindingResult().getFieldErrors().forEach(fieldError -> map.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    //3 Generic Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception exp) {
        Map<String,String> map = new HashMap<>();
        map.put("message", exp.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
    }
}
