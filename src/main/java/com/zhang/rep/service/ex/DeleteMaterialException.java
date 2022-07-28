package com.zhang.rep.service.ex;

public class DeleteMaterialException extends ServiceException{
    public DeleteMaterialException() {
    }

    public DeleteMaterialException(String message) {
        super(message);
    }

    public DeleteMaterialException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteMaterialException(Throwable cause) {
        super(cause);
    }

    public DeleteMaterialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
