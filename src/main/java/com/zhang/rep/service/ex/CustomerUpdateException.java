package com.zhang.rep.service.ex;

/**
 * 修改用户数据错误
 */
public class CustomerUpdateException extends ServiceException{
    public CustomerUpdateException() {
    }

    public CustomerUpdateException(String message) {
        super(message);
    }

    public CustomerUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerUpdateException(Throwable cause) {
        super(cause);
    }

    public CustomerUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
