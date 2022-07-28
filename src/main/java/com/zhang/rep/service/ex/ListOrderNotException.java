package com.zhang.rep.service.ex;

/**
 * 返回对应订单数据错误
 */
public class ListOrderNotException extends ServiceException{
    public ListOrderNotException() {
    }

    public ListOrderNotException(String message) {
        super(message);
    }

    public ListOrderNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListOrderNotException(Throwable cause) {
        super(cause);
    }

    public ListOrderNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
