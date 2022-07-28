package com.zhang.rep.service.ex;

/**
 * 添加货品异常
 */
public class AddProductException extends ServiceException{
    public AddProductException() {
    }

    public AddProductException(String message) {
        super(message);
    }

    public AddProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddProductException(Throwable cause) {
        super(cause);
    }

    public AddProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
