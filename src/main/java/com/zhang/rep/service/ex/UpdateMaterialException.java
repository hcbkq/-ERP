package com.zhang.rep.service.ex;

/**
 * 材料修改异常
 */
public class UpdateMaterialException extends ServiceException{
    public UpdateMaterialException() {
    }

    public UpdateMaterialException(String message) {
        super(message);
    }

    public UpdateMaterialException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateMaterialException(Throwable cause) {
        super(cause);
    }

    public UpdateMaterialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
