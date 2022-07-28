package com.zhang.rep.service.ex.Consumption;

import com.zhang.rep.service.ex.ServiceException;

public class DeleteConsumptionException extends ServiceException {
    public DeleteConsumptionException() {
    }

    public DeleteConsumptionException(String message) {
        super(message);
    }

    public DeleteConsumptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteConsumptionException(Throwable cause) {
        super(cause);
    }

    public DeleteConsumptionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
