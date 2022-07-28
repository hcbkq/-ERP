package com.zhang.rep.service.ex;

/**
 * 添加材料异常
 */
public class AddMaterialException extends ServiceException{
    public AddMaterialException() {
    }

    public AddMaterialException(String message) {
        super(message);
    }

    public AddMaterialException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddMaterialException(Throwable cause) {
        super(cause);
    }

    public AddMaterialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
