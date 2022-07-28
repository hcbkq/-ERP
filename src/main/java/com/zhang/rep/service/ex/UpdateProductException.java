package com.zhang.rep.service.ex;

/**
 * 更新产品异常
 */
public class UpdateProductException extends ServiceException{
    public UpdateProductException() {
    }

    public UpdateProductException(String message) {
        super(message);
    }

    public UpdateProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateProductException(Throwable cause) {
        super(cause);
    }

    public UpdateProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
