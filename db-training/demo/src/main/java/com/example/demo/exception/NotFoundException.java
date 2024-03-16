package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

    private Integer code;

    public NotFoundException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
