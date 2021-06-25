package com.example.productsearch.config;

import com.example.exception.ExceptionResponse;
import com.example.exception.ProductSearchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductSearchException.class)
    public ResponseEntity<ExceptionResponse> handleProductSearchException(ProductSearchException ex) {
        log.error("ProductSearchException : ", ex);
        ExceptionResponse error = ExceptionResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionResponse> exception(Exception e) {
        log.error("Exception : ", e);
        ExceptionResponse error = ExceptionResponse.builder()
                .message(e.getLocalizedMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
