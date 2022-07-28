package com.zhang.rep.service.ex;

/**
 * 修改用户有无订单状态错误
 */
public class CustomerUpdateIFOrderException extends ServiceException{
    public CustomerUpdateIFOrderException() {
        super();
    }

    public CustomerUpdateIFOrderException(String message) {
        super(message);
    }

    public CustomerUpdateIFOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerUpdateIFOrderException(Throwable cause) {
        super(cause);
    }

    protected CustomerUpdateIFOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
