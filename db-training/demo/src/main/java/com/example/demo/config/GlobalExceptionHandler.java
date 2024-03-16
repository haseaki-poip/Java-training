package com.example.demo.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.demo.error.ApiError;
import com.example.demo.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @SuppressWarnings("null")
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
            HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        // リクエストのBodyのセット
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(statusCode.value(), ex.getMessage(), path);

        return super.handleExceptionInternal(ex, apiError, headers, statusCode, request);
    }

    // @ExceptionHandler(NotFoundException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    // public String handleNotFoundException(NotFoundException ex) {
    // System.out.println("NotFoundException caught: " + ex.getMessage());

    // return ex.getMessage();
    // }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex,
            WebRequest request) {
        // リクエストのBodyのセット
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ApiError apiError = new ApiError(ex.getCode(), ex.getMessage(), path);

        // リクエストヘッダーの作成
        HttpHeaders httpHeaders = new HttpHeaders();

        return handleExceptionInternal(ex, apiError, httpHeaders, HttpStatus.NOT_FOUND, request);
    }
}
