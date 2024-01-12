package com.javatechie.handler;

import com.javatechie.dto.ErrorDto;
import com.javatechie.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProductExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public ProblemDetail handleProductNotFoundException(ProductNotFoundException ex) {
//        return ErrorDto.builder()
//                .status("FAIL")
//                .errorMessage(ex.getMessage())
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(DuplicateProductException.class)
    public ProblemDetail handleDuplicateProductException(DuplicateProductException ex) {
//        return ErrorDto.builder()
//                .status("FAIL")
//                .errorMessage(ex.getMessage())
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }


    @ExceptionHandler(ProductServiceException.class)
    public ProblemDetail handleProductServiceException(ProductServiceException ex) {
//        return ErrorDto.builder()
//                .status("FAIL")
//                .errorMessage(ex.getMessage())
//                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });
        return errorMap;
    }
}
