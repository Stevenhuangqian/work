package com.core.work.exception;

public class BaseCustomException extends Exception {

    //异常信息
    private String message;
    

    public BaseCustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
