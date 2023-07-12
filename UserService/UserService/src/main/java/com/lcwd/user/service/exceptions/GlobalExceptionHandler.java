package com.lcwd.user.service.exceptions;

import com.lcwd.user.service.payload.ApiResponse;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
//        String message = ex.getMessage();
//        ApiResponse response = ApiResponse.builder().message(message).status(HttpStatus.NOT_FOUND).build();
//        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
//    }
//}
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
