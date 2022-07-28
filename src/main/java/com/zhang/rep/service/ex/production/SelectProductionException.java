package com.zhang.rep.service.ex.production;

import com.zhang.rep.service.ex.ServiceException;

public class SelectProductionException extends ServiceException {
    public SelectProductionException() {
    }

    public SelectProductionException(String message) {
        super(message);
    }

    public SelectProductionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SelectProductionException(Throwable cause) {
        super(cause);
    }

    public SelectProductionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
