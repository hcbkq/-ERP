package com.zhang.rep.service.ex;

public class WarehouseInsufficientGoodsException extends ServiceException{
    public WarehouseInsufficientGoodsException() {
    }

    public WarehouseInsufficientGoodsException(String message) {
        super(message);
    }

    public WarehouseInsufficientGoodsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WarehouseInsufficientGoodsException(Throwable cause) {
        super(cause);
    }

    public WarehouseInsufficientGoodsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
