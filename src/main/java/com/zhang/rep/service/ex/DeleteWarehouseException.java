package com.zhang.rep.service.ex;

public class DeleteWarehouseException extends ServiceException{
    public DeleteWarehouseException() {
    }

    public DeleteWarehouseException(String message) {
        super(message);
    }

    public DeleteWarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteWarehouseException(Throwable cause) {
        super(cause);
    }

    public DeleteWarehouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
