package com.zhang.rep.service.ex.production;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteProductionException extends ServiceException {
    public DeleteProductionException() {
    }

    public DeleteProductionException(String message) {
        super(message);
    }

    public DeleteProductionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteProductionException(Throwable cause) {
        super(cause);
    }

    public DeleteProductionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
