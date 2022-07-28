package com.zhang.rep.service.ex;

/**
 * 删除订单产生异常
 */
public class DeleteOrderException extends ServiceException{
    public DeleteOrderException() {
    }

    public DeleteOrderException(String message) {
        super(message);
    }

    public DeleteOrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteOrderException(Throwable cause) {
        super(cause);
    }

    public DeleteOrderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
