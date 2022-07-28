package com.zhang.rep.service.ex;

/**
 * 查询仓库数据时产生的错误
 */
public class SelectWarehouseException extends ServiceException{
    public SelectWarehouseException() {
    }

    public SelectWarehouseException(String message) {
        super(message);
    }

    public SelectWarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectWarehouseException(Throwable cause) {
        super(cause);
    }

    public SelectWarehouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
