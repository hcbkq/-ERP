package com.zhang.rep.service.ex;

/**
 * 更新仓库数据
 */
public class UpdateWarehouseException extends ServiceException{
    public UpdateWarehouseException() {
    }

    public UpdateWarehouseException(String message) {
        super(message);
    }

    public UpdateWarehouseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateWarehouseException(Throwable cause) {
        super(cause);
    }

    public UpdateWarehouseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
