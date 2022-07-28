package com.zhang.rep.service.ex;

/**
 * 客户数据不存在的异常
 */
public class CustomerNotExistenceException extends ServiceException{
    public CustomerNotExistenceException() {
    }

    public CustomerNotExistenceException(String message) {
        super(message);
    }

    public CustomerNotExistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotExistenceException(Throwable cause) {
        super(cause);
    }

    public CustomerNotExistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
