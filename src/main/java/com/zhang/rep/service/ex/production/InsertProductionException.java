package com.zhang.rep.service.ex.production;

import com.zhang.rep.service.ex.ServiceException;

public class InsertProductionException extends ServiceException {
    public InsertProductionException() {
    }

    public InsertProductionException(String message) {
        super(message);
    }

    public InsertProductionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertProductionException(Throwable cause) {
        super(cause);
    }

    public InsertProductionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
