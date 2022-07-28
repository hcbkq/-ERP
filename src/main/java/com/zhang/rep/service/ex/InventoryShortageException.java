package com.zhang.rep.service.ex;

public class InventoryShortageException extends ServiceException{
    public InventoryShortageException() {
    }

    public InventoryShortageException(String message) {
        super(message);
    }

    public InventoryShortageException(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryShortageException(Throwable cause) {
        super(cause);
    }

    public InventoryShortageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
