package com.zhang.rep.service.ex;

/**
 * 插入仓库数据错误
 */
public class InsertWarehouseException extends ServiceException{
    public InsertWarehouseException() {
    }

    public InsertWarehouseException(String message) {
        super(message);
    }

    public InsertWarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertWarehouseException(Throwable cause) {
        super(cause);
    }

    public InsertWarehouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
