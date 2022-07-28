package com.zhang.rep.service.ex;

/**
 * 删除客户异常
 */
public class DeleteCustomerException extends ServiceException{
    public DeleteCustomerException() {
    }

    public DeleteCustomerException(String message) {
        super(message);
    }

    public DeleteCustomerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteCustomerException(Throwable cause) {
        super(cause);
    }

    public DeleteCustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
