package com.zhang.rep.service.ex;

/**
 * 客户订单达到上线异常
 */
public class OrderCountLimitException extends ServiceException{
    public OrderCountLimitException() {
    }

    public OrderCountLimitException(String message) {
        super(message);
    }

    public OrderCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderCountLimitException(Throwable cause) {
        super(cause);
    }

    public OrderCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
