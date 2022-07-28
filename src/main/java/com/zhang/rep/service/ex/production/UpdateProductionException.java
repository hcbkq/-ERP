package com.zhang.rep.service.ex.production;

import com.zhang.rep.service.ex.ServiceException;

public class UpdateProductionException extends ServiceException {
    public UpdateProductionException() {
    }

    public UpdateProductionException(String message) {
        super(message);
    }

    public UpdateProductionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateProductionException(Throwable cause) {
        super(cause);
    }

    public UpdateProductionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
