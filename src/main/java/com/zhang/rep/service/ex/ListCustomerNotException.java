package com.zhang.rep.service.ex;

/**
 * 客户数据列表返回错误异常
 */
public class ListCustomerNotException extends ServiceException{
    public ListCustomerNotException() {
    }

    public ListCustomerNotException(String message) {
        super(message);
    }

    public ListCustomerNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListCustomerNotException(Throwable cause) {
        super(cause);
    }

    public ListCustomerNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
