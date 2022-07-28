package com.zhang.rep.service.ex;

/**
 * 客户数据数量超出异常
 */
public class CustomerCountLimitException extends ServiceException{
    public CustomerCountLimitException() {
        super();
    }

    public CustomerCountLimitException(String message) {
        super(message);
    }

    public CustomerCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerCountLimitException(Throwable cause) {
        super(cause);
    }

    protected CustomerCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
