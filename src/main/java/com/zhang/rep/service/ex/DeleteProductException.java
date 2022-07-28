package com.zhang.rep.service.ex;

/**
 * 删除产品错误
 */
public class DeleteProductException extends ServiceException{
    public DeleteProductException() {
    }

    public DeleteProductException(String message) {
        super(message);
    }

    public DeleteProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteProductException(Throwable cause) {
        super(cause);
    }

    public DeleteProductException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
