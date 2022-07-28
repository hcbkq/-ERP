package com.zhang.rep.service.ex;

public class SelectProductException extends ServiceException{
    public SelectProductException() {
    }

    public SelectProductException(String message) {
        super(message);
    }

    public SelectProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectProductException(Throwable cause) {
        super(cause);
    }

    public SelectProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
